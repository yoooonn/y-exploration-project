package top.yooonn.explore.mybatis;

import com.alibaba.fastjson.JSON;
import top.yooonn.explore.basic.dao.ActorMapper;
import top.yooonn.explore.basic.dao.model.Actor;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-configuration.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream);
        Configuration configuration = xmlConfigBuilder.parse();
        log.info(configuration.hasMapper(ActorMapper.class) + "");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActorMapper actorMapper = sqlSession.getMapper(ActorMapper.class);
        Actor actor = actorMapper.selectByPrimaryKey(1L);
        sqlSession.commit();
        log.info(JSON.toJSONString(actor));
    }
}
