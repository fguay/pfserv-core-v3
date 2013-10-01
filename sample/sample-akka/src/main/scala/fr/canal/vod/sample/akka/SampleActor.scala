package fr.canal.vod.sample.akka

import akka.actor.Actor
import scala.beans.BeanProperty
import fr.canal.vod.sample.api.dto.Sample
import scala.concurrent.Future
import fr.canal.vod.sample.biz.SampleBiz
import org.springframework.beans.factory.annotation.Autowired
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.springframework.stereotype.Component

trait SampleActor {

  def jpaSample( param : String)  : Future[Sample]

  def docSample( param : String)  : Future[Sample]

}

@Component("sampleActor")
class SampleActorImpl extends SampleActor {

  @Autowired
  @BeanProperty
  var sampleBiz : SampleBiz = _

  def jpaSample(param: String): Future[Sample] = {
   future {
     sampleBiz.jpaSample(param)
   }
  }

  def docSample(param: String): Future[Sample] = {
   future {
      sampleBiz.docSample(param)
    }
  }



}