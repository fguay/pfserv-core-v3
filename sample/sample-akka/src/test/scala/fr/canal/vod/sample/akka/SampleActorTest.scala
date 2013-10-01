package fr.canal.vod.sample.akka


import org.springframework.beans.factory.annotation.Autowired
import junit.framework.Test
import akka.testkit.TestActorRef
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.junit.Assert


@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:sample-akka-beans.xml", "classpath:test-sample-akka-beans.xml"))
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
class SampleActorTest {

  @Autowired
  var sampleActor: SampleActor = _


}
