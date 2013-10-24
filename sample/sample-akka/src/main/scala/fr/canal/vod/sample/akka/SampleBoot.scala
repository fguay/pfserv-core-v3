package fr.canal.vod.sample.akka

import scala.concurrent.duration._

import akka.kernel.Bootable
import akka.actor._
import akka.routing.RoundRobinRouter
import org.springframework.context.support.ClassPathXmlApplicationContext
import fr.canal.vod.sample.api.akka.SampleActor
import fr.canal.vod.akka.DefaultSupervisor
import com.typesafe.config.ConfigFactory

class SampleBoot extends Bootable {

   val nbOfInstances : Int = 5

   val system = ActorSystem("sample", ConfigFactory.load.getConfig("sample"))
   val springCtx = new ClassPathXmlApplicationContext("sample-biz-beans.xml")
   val actor : SampleActorImpl = springCtx.getBean("sampleActor").asInstanceOf[SampleActorImpl]

   val sampleRooter : SampleActor = TypedActor(system).typedActorOf(TypedProps(classOf[SampleActor], actor).withDispatcher("sample-dispatcher"), "sample")
   val supervisor = system.actorOf(Props[DefaultSupervisor], "supervisor")


    def startup = {
      // Create the 'greeter' actor
     supervisor ! sampleRooter
     println("Started Actor : " + TypedActor(system).getActorRefFor(sampleRooter).path)
     println("Started Supervisor : " + supervisor.path)



    }

    def shutdown = {
      system.shutdown()
    }

}
