package com.lordofthejars.nosqlunit.mongodb;

import com.lordofthejars.nosqlunit.core.ExtPropertyGetter;
import com.lordofthejars.nosqlunit.core.PropertyGetter;
import com.mongodb.Mongo;
import static ch.lambdaj.collection.LambdaCollections.with;
import static org.hamcrest.CoreMatchers.anything;

import fr.canal.vod.test.MongoTestCase;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class ExtSpringMongoDbRule extends MongoDbRule {

    private MongoDbConfiguration mongoDbConfiguration;

    private PropertyGetter<ApplicationContext> propertyGetter = new ExtPropertyGetter<ApplicationContext>();


    public ExtSpringMongoDbRule(String databaseName){
        this(MongoDbConfigurationBuilder.mongoDb().databaseName(databaseName).build());
    }

    public ExtSpringMongoDbRule(MongoDbConfiguration mongoDbConfiguration) {
        super(mongoDbConfiguration);
        this.mongoDbConfiguration = mongoDbConfiguration;
    }

    public ExtSpringMongoDbRule(MongoDbConfiguration mongoDbConfiguration, Object object) {
        super(mongoDbConfiguration, object);
        this.mongoDbConfiguration = mongoDbConfiguration;
    }

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object testObject) {
        this.databaseOperation = new MongoOperation(definedMongo(testObject), this.mongoDbConfiguration);
        return super.apply(base, method, testObject);
    }

    private Mongo definedMongo(Object testObject) {

        ApplicationContext applicationContext = propertyGetter.propertyByType(testObject, ApplicationContext.class);

        Map<String, Mongo> beansOfType = ((MongoTestCase)testObject).getApplicationContext().getBeansOfType(Mongo.class);

        if(beansOfType == null) {
            throw new IllegalArgumentException(
                    "At least one Mongo instance should be defined into Spring Application Context.");
        }

        Mongo mongo = with(beansOfType).values().first(anything());

        if (mongo == null) {
            throw new IllegalArgumentException(
                    "At least one Mongo instance should be defined into Spring Application Context.");
        }

        return mongo;

    }


}
