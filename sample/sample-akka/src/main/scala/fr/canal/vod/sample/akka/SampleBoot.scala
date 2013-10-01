package fr.canal.vod.sample.akka

import scala.concurrent.duration._

import akka.kernel.Bootable
import akka.actor._
import akka.routing.RoundRobinRouter
import org.springframework.context.support.ClassPathXmlApplicationContext

class SampleBoot extends Bootable {

    val system = ActorSystem("sample")

    val nbOfInstances : Int = 5

    def startup = {
      // Create the 'greeter' actor
      val sprintCtx = new ClassPathXmlApplicationContext("sample-biz-beans.xml")
      val sampleRooter = TypedActor(system).typedActorOf(TypedProps(classOf[SampleActor], new SampleActorImpl()))

    }

    def shutdown = {
      system.shutdown()
    }

}
