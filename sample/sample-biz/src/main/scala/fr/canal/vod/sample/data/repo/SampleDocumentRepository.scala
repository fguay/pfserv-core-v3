package fr.canal.vod.sample.data.repo

import org.springframework.stereotype.Repository
import fr.canal.vod.sample.data.doc.SampleDocument
import org.springframework.data.repository.CrudRepository

@Repository
trait SampleDocumentRepository extends CrudRepository[SampleDocument, java.lang.String] {

  def findByName(name: String): SampleDocument

}