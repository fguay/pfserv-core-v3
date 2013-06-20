package fr.canal.vod.sample.data.repo

import org.springframework.test.context.transaction.TransactionConfiguration
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Test
import org.junit.Assert
import fr.canal.vod.sample.data.entity.SampleEntity
import java.lang.Iterable
import fr.canal.vod.test.EntityTestCase

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:sample-ws-beans.xml", "classpath:test-sample-ws-beans.xml"))
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
class SampleEntityRepositoryTest extends EntityTestCase {

  @Autowired
  var sampleEntityRepository: SampleEntityRepository = _

  @Test
  def findAll(){
    val results : Iterable[SampleEntity] = sampleEntityRepository.findAll()
    Assert.assertNotNull(results)
  }

}
