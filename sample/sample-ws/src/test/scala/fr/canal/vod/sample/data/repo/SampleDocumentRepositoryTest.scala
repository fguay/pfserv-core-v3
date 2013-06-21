package fr.canal.vod.sample.data.repo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.junit.{Test, Before, After}
import org.springframework.test.context.ContextConfiguration
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.junit.Assert
import fr.canal.vod.sample.data.doc.SampleDocument
import fr.canal.vod.sample.data.repo.SampleDocumentRepository

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:sample-ws-beans.xml", "classpath:test-sample-ws-beans.xml"))
class SampleDocumentRepositoryTest {
  @Before def setUp {
    mongoTemplate.dropCollection("sampleDocument")
  }

  @After def tearDown {
    mongoTemplate.dropCollection("sampleDocument")
  }

  @Test def insert_and_find_sampleDocument_based_on_id {
    val sampleDocument: SampleDocument = new SampleDocument
    sampleDocument.setName("Michal")
    sampleDocument.setAge(32)
    sampleRepository.save(sampleDocument)
    val savedSampleDocument: SampleDocument = sampleRepository.findOne(sampleDocument.getId)
    Assert.assertEquals(sampleDocument.getName, savedSampleDocument.getName)
    Assert.assertEquals(sampleDocument.getAge, savedSampleDocument.getAge)
  }

  @Test def find_all_sampleDocuments {
    val sampleDocument: SampleDocument = new SampleDocument
    sampleDocument.setName("Michal")
    sampleDocument.setAge(32)
    sampleRepository.save(sampleDocument)
    Assert.assertEquals(1, sampleRepository.findAll.asInstanceOf[java.util.List[SampleDocument]].size)
  }

  @Autowired private val sampleRepository: SampleDocumentRepository = null
  @Autowired private val mongoTemplate: MongoTemplate = null
}