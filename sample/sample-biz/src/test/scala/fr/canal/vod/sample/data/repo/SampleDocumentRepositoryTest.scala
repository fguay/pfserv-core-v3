package fr.canal.vod.sample.data.repo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ContextConfiguration
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import fr.canal.vod.sample.data.doc.SampleDocument
import com.lordofthejars.nosqlunit.annotation.UsingDataSet
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum


import scala.beans.BeanProperty
import fr.canal.vod.test.MongoTestCase
import org.junit.{Assert, Test}

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:sample-biz-beans.xml", "classpath:test-sample-biz-beans.xml"))
@UsingDataSet(locations = Array{"SampleDocumentRepositoryTest.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
class SampleDocumentRepositoryTest extends MongoTestCase {

  @Autowired @BeanProperty var sampleRepository: SampleDocumentRepository = _

  @Test def insertSample() {
    val sampleDocument: SampleDocument = new SampleDocument
    sampleDocument.setName("Michal")
    sampleDocument.setAge(32)
    sampleDocument.setId("2");
    sampleRepository.save(sampleDocument)
    val savedSampleDocument: SampleDocument = sampleRepository.findOne(sampleDocument.getId)
    Assert.assertEquals(sampleDocument.getName, savedSampleDocument.getName)
    Assert.assertEquals(sampleDocument.getAge, savedSampleDocument.getAge)
  }

  @Test
  def findAllSamples() {
    Assert.assertEquals(1, sampleRepository.findAll.asInstanceOf[java.util.List[SampleDocument]].size)
  }
}
