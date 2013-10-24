package fr.canal.vod.sample.api.akka

import scala.concurrent.Future
import fr.canal.vod.sample.api.dto.Sample


trait SampleActor {

  def jpaSample( param : String)  : Future[Sample]

  def docSample( param : String)  : Future[Sample]

}
