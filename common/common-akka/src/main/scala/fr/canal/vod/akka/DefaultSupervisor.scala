package fr.canal.vod.akka

import akka.actor.{Props, Actor}
import fr.canal.vod.api.exception.{BizException, TechnicalException}


class DefaultSupervisor extends Actor {

    import akka.actor.OneForOneStrategy
    import akka.actor.SupervisorStrategy._
    import scala.concurrent.duration._

    override val supervisorStrategy =
      OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
        case _: BizException             ⇒ Resume
        case _: TechnicalException       ⇒ Restart
        case _: Throwable                ⇒ Escalate
      }

    def receive = {
      case p: Props ⇒ sender ! context.actorOf(p)
    }

}
