package fr.canal.vod.sample.test

import org.springframework.test.context.transaction.TransactionConfiguration
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Test
import junit.framework.Assert
import fr.canal.vod.sample.data.repo.SampleRepository
import fr.canal.vod.sample.data.entity.SampleEntity
import java.lang.Iterable
import fr.canal.vod.test.EntityTestCase

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array( "classpath:/sample-beans.xml", "classpath:/sample-beans-test.xml" ))
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
class SampleRepositoryTest extends EntityTestCase {

  @Autowired
  var sampleRepository: SampleRepository = _

  @Test
  def findAll(){
    val results : Iterable[SampleEntity] = sampleRepository.findAll()
    Assert.assertNotNull(results)
  }

}
