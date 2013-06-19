package fr.canal.vod.sample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import scala.beans.BeanProperty

@Document class SampleDBO {

  @BeanProperty @Id var id: String = _
  @BeanProperty var name: String = _
  @BeanProperty var age: Integer = _
}