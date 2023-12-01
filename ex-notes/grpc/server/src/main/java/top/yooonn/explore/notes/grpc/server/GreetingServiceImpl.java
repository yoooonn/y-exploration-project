package top.yooonn.explore.notes.grpc.server;

import top.yooonn.explore.notes.grpc.simple.proto.Greeting;
import top.yooonn.explore.notes.grpc.simple.proto.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2023.02.02
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);

    @Override
    public void greeting(Greeting.Request request, StreamObserver<Greeting.Response> responseObserver) {
        log.info("received {}", request);
        Greeting.Response response = Greeting.Response.newBuilder().setCode("Hi, " + request.getName() + ". I'm here!").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
