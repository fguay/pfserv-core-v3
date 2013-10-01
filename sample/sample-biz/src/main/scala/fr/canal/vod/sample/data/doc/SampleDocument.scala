package fr.canal.vod.sample.data.doc

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import scala.beans.BeanProperty
import javax.persistence.GeneratedValue

@Document class SampleDocument {

  @BeanProperty
  @Id
  @GeneratedValue
  var id: java.lang.String = _

  @BeanProperty var name: String = _
  @BeanProperty var age: Integer = _

  @BeanProperty var parent: SampleDocument = _
  @BeanProperty var childSample: List[SampleDocument] = _

}