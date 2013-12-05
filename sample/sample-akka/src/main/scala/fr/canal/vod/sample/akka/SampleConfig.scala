package fr.canal.vod.sample.akka

import fr.canal.vod.akka.{DefaultSupervisor, SpringExtentionImpl}
import akka.actor.{TypedActor, Props, TypedProps, ActorSystem}
import org.springframework.beans.factory.config.BeanDefinition

import org.springframework.scala.context.function.FunctionalConfiguration
import org.springframework.context.ApplicationContext
import com.typesafe.config.ConfigFactory
import fr.canal.vod.sample.api.akka.SampleActor


class SampleConfig extends FunctionalConfiguration {

  importXml("classpath:sample-akka-beans.xml")

  /**
   * Load implicit context
   */
  implicit val ctx = beanFactory.asInstanceOf[ApplicationContext]


  /**
   * Actor system singleton for this application.
   */
  val system = bean("system") {
    val system = ActorSystem("sample", ConfigFactory.load.getConfig("sample"))
    SpringExtentionImpl(system)
    system
  }

  val supervisor = bean("supervisor", scope=BeanDefinition.SCOPE_PROTOTYPE){
    system().actorOf(Props[DefaultSupervisor], "supervisor")
  }

  val actor = bean("sample", scope=BeanDefinition.SCOPE_PROTOTYPE){
    val sampleActor : SampleActorImpl = getBean[SampleActorImpl]("sampleActor")
    val sampleRooter : SampleActor = TypedActor(system()).typedActorOf(TypedProps(classOf[SampleActor], sampleActor).withDispatcher("sample-dispatcher"), "sample")
    supervisor() ! sampleRooter
    sampleActor
  }



}
