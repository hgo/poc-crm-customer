package tr.com.turkcell.crm.customer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CustomerApplicationTests
{
    final static Logger logger = LoggerFactory.getLogger(CustomerApplicationTests.class);

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads()
    {

        final String url = applicationContext.getEnvironment()
                .getProperty("spring.datasource.url");

        logger.info("url : {}", url);
    }

}
