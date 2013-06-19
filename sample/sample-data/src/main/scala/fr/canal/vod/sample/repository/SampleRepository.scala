package fr.canal.vod.sample.repository

import fr.canal.vod.sample.domain.SampleDBO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository
import java.util.List
import collection.JavaConversions._

@Repository class SampleRepository {
  @Autowired var template: MongoTemplate = _

  def insert(sampleDBO: SampleDBO) {
    template.insert(sampleDBO)
  }

  def findAll: List[SampleDBO] = {
    template.findAll(classOf[SampleDBO])
  }

  def findById(id: String): SampleDBO = {
    template.findById(id, classOf[SampleDBO])
  }

}