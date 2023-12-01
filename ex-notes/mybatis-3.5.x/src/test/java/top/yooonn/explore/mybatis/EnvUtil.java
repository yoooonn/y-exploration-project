package top.yooonn.explore.mybatis;

import top.yooonn.explore.basic.dao.ActorMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yooonn
 * @date 2021.03.26
 */
@Slf4j
public abstract class EnvUtil {

    protected MapperProxyFactory<ActorMapper> actorMapperProxyFactory() {
        return new MapperProxyFactory<>(ActorMapper.class);
    }

    protected SqlSession sqlSession() {
        Configuration configuration = configuration();
        log.info(configuration.hasMapper(ActorMapper.class) + "");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory.openSession();
    }

    protected Configuration configuration() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-configuration.xml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("com.ycourlee.explore.mybatis.EnvUtil.configuration, e: {}", e.getMessage());
        }
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream);
        return xmlConfigBuilder.parse();
    }
}
