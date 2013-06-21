package fr.canal.vod.ext.third.impl


import fr.canal.vod.ext.third.ThirdManager
import org.springframework.stereotype.Component

@Component("thirdManager")
class DefaultThirdManager() extends ThirdManager {

  def third ( param : String) : String = {
     param
  }

}

