package example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@SpringBootApplication
public class ExampleApplication {

    @Bean
    MongoCustomConversions customConversions() {

        return MongoCustomConversions.create(config -> {});
    }
}
