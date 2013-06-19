package fr.canal.vod.sample.test

import junit.framework.Assert

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import fr.canal.vod.sample.biz.SampleBiz
import fr.canal.vod.test.EntityTestCase


@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("classpath:/sample-beans.xml", "classpath:/sample-beans-test.xml"))
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
class SampleManagerTest extends EntityTestCase {

  @Autowired
  var sampleManager: SampleBiz = _

  @Test
  def testSample() {
    Assert.assertNotNull(sampleManager.sample("coucou"));
    Assert.assertNotNull(sampleManager.sample("root").getChildSample())
  }
}
