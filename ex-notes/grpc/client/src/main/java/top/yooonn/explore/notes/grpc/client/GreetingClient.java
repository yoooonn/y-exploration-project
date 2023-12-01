package top.yooonn.explore.notes.grpc.client;

import com.ycourlee.explore.notes.grpc.simple.proto.Greeting;
import com.ycourlee.explore.notes.grpc.simple.proto.GreetingServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 * @author yooonn
 * @date 2023.02.02
 */
public class GreetingClient {

    private static final Logger                                          log = LoggerFactory.getLogger(GreetingClient.class);
    private final        GreetingServiceGrpc.GreetingServiceBlockingStub greetingService;

    public GreetingClient(Channel channel) {
        this.greetingService = GreetingServiceGrpc.newBlockingStub(channel);
    }

    public Greeting.Response greeting(String name, String greeting) {
        Greeting.Request request = Greeting.Request.newBuilder().setName(name).setGreeting(greeting).build();
        log.info("request {}", request);
        Greeting.Response response = greetingService.greeting(request);
        log.info("response {}", response);
        return response;
    }

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7007).usePlaintext().build();
        GreetingClient greetingClient = new GreetingClient(channel);

        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] s;
                if (line == null || (s = line.split(" ")).length < 2) {
                    continue;
                }
                greetingClient.greeting(s[0], s[1]);
            }
        } catch (Exception e) {
            log.info("", e);
        } finally {
            channel.shutdown().awaitTermination(3, TimeUnit.SECONDS);
        }
    }
}
