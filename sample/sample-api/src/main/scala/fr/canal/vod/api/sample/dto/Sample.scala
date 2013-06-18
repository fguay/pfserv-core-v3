package fr.canal.vod.api.sample.dto

import java.util.List
import scala.beans.BeanProperty

class Sample() extends Serializable {

  @BeanProperty var id : Integer  = _

  @BeanProperty var name : String = _

  @BeanProperty var childSample : List[Sample] = _

}