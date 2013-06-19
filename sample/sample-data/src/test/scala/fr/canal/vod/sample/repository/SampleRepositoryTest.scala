package fr.canal.vod.sample.repository

import fr.canal.vod.sample.domain.SampleDBO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.junit.{Test, Before, After}
import org.springframework.test.context.ContextConfiguration
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import junit.framework.Assert

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:application-context.xml"))
class SampleRepositoryTest {
  @Before def setUp {
    mongoTemplate.dropCollection("sampleDBO")
  }

  @After def tearDown {
    mongoTemplate.dropCollection("sampleDBO")
  }

  @Test def insert_and_find_sampleDBO_based_on_id {
    val sampleDBO: SampleDBO = new SampleDBO
    sampleDBO.setName("Michal")
    sampleDBO.setAge(32)
    sampleRepository.insert(sampleDBO)
    val savedSampleDBO: SampleDBO = sampleRepository.findById(sampleDBO.getId)
    Assert.assertEquals(sampleDBO.getName, savedSampleDBO.getName)
    Assert.assertEquals(sampleDBO.getAge, savedSampleDBO.getAge)
  }

  @Test def find_all_sampleDBOs {
    val sampleDBO: SampleDBO = new SampleDBO
    sampleDBO.setName("Michal")
    sampleDBO.setAge(32)
    sampleRepository.insert(sampleDBO)
    Assert.assertEquals(1, sampleRepository.findAll.size)
  }

  @Autowired private val sampleRepository: SampleRepository = null
  @Autowired private val mongoTemplate: MongoTemplate = null
}