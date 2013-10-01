package fr.canal.vod.sample.api.dto

import scala.beans.BeanProperty
import java.util

class Sample extends Serializable {

  @BeanProperty var id : String  = _

  @BeanProperty var name : String = _

  @BeanProperty var childSample : util.List[Sample] = _

}