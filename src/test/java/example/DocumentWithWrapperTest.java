package example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ContextConfiguration(classes = ExampleApplication.class)
class DocumentWithWrapperTest {

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Test
    void test() {
        DocumentWithWrapper documentWithWrapper = new DocumentWithWrapper(
                new Wrapper<>(DocumentWithWrapper.MyEnum.ONE, 3)
        );
        mongoTemplate.save(documentWithWrapper)
                .thenMany(
                        mongoTemplate.aggregate(Aggregation.newAggregation(Aggregation.sample(3)),
                                DocumentWithWrapper.class,
                                DocumentWithWrapper.class))
                .doOnNext(document -> assertThat(document.getMyWrappedEnum().getValue())
                        .isInstanceOf(DocumentWithWrapper.MyEnum.class))
                .blockLast();
    }
}