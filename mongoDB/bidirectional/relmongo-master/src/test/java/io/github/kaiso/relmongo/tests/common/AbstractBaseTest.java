package io.github.kaiso.relmongo.tests.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import io.github.kaiso.relmongo.config.EnableRelMongo;

@EnableRelMongo
@EnableMongoRepositories(basePackages = "io.github.kaiso.relmongo.data")
@ExtendWith(SpringExtension.class)
public abstract class AbstractBaseTest {

    /**
     * please store Starter or RuntimeConfig in a static final field
     * if you want to use artifact store caching (or else disable caching)
     */
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();


    private static MongoClient _mongo;

    @BeforeAll
    protected static void setUp() throws Exception {
        _mongo = new MongoClient("localhost", 27017);
        System.out.println(_mongo);
    }

    @AfterAll
    protected static void tearDown() throws Exception {
    }

    @Bean
    public Mongo mongo() {
        return _mongo;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(_mongo, "test");
    }

}
