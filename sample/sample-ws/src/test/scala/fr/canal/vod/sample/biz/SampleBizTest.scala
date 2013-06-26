package fr.canal.vod.sample.biz

import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import fr.canal.vod.test.EntityTestCase


@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:sample-ws-beans.xml", "classpath:test-sample-ws-beans.xml"))
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
class SampleBizTest extends EntityTestCase {

  @Autowired
  var sampleBiz: SampleBiz = _

  @Test
  def testSample() {
    Assert.assertNotNull(sampleBiz.jpaSample("coucou"))
    Assert.assertNotNull(sampleBiz.jpaSample("root").getChildSample)
  }
}
