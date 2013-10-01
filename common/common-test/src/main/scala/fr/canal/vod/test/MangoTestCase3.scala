package fr.canal.vod.test

import com.lordofthejars.nosqlunit.mongodb.{InMemoryMongoDb, MongoDbRule}
import org.junit.{Rule, ClassRule, After, Before}
import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder._
import org.springframework.beans.factory.annotation.Autowired
import scala.beans.BeanProperty
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule
import org.springframework.context.ApplicationContext

abstract class MangoTestCase3 {

  @Autowired @BeanProperty var applicationContext: ApplicationContext = _

  @Before
  def load(){
         System.out.println("load")
  }

  @After
  def clear() {
    System.out.println("clear")
  }

  val mongoDbRule: MongoDbRule  = newMongoDbRule().defaultSpringMongoDb("test");

  @Rule
  def mongoDbRuleRef: MongoDbRule =  mongoDbRule
}

object  MangoTestCase3 {
  @ClassRule def managedMongoDb: InMemoryMongoDb  = newInMemoryMongoDbRule().build();

}