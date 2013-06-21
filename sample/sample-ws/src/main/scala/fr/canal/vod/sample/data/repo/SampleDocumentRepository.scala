package fr.canal.vod.sample.data.repo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository
import java.util.List
import collection.JavaConversions._
import fr.canal.vod.sample.data.doc.SampleDocument

@Repository class SampleDocumentRepository {

  @Autowired var template: MongoTemplate = _

  def insert(sampleDocument: SampleDocument) {
    template.insert(sampleDocument)
  }

  def findAll: List[SampleDocument] = {
    template.findAll(classOf[SampleDocument])
  }

  def findById(id: String): SampleDocument = {
    template.findById(id, classOf[SampleDocument])
  }

  def findByName(name: String): SampleDocument = {
    template.findByName(name, classOf[SampleDocument])
  }

}