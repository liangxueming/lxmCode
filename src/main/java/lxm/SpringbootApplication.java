package lxm;

import lxm.redis.TestRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: liangxm
 * @Date: 2020/6/8 - 06 - 08 - 21:34
 * @Description: lxm
 * @version: 1.0
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

//        SpringApplication.run(SpringbootApplication.class, args);

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);
        TestRedis redis = ctx.getBean(TestRedis.class);
        redis.testRedis();

    }

}

