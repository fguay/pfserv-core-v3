package fr.canal.vod.sample.data.doc

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import scala.beans.BeanProperty

@Document class SampleDocument {

  @BeanProperty @Id var id: String = _
  @BeanProperty var name: String = _
  @BeanProperty var age: Integer = _
  @BeanProperty var parent: SampleDocument = _

}