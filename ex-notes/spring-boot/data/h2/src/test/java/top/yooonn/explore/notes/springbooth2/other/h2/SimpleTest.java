package top.yooonn.explore.notes.springbooth2.other.h2;

import lombok.SneakyThrows;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author yooonn
 * @date 2022.12.22
 */
public class SimpleTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleTest.class);

    static JdbcDataSource dataSource;

    static {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setLogWriter(new PrintWriter(System.out));

    }

    @BeforeEach
    void setup() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Test
    void mainTest() {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select 1");
        log.info("execute: {}", execute);
        Thread.sleep(1000000000L);
    }
}
