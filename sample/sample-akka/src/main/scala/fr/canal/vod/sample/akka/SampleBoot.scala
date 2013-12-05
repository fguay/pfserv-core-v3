package fr.canal.vod.sample.akka

import scala.concurrent.duration._

import akka.kernel.Bootable
import akka.actor._
import org.springframework.scala.context.function.{FunctionalConfiguration, FunctionalConfigApplicationContext}

class SampleBoot extends Bootable {

  implicit val springCtx = FunctionalConfigApplicationContext(classOf[SampleConfig])
  val system = springCtx.getBean(classOf[ActorSystem])

  def startup = {
     println("Started Service : Sample")
  }

  def shutdown = {
      system.shutdown()
  }



}
