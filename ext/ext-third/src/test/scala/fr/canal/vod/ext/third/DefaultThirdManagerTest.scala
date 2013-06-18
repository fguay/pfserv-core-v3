package fr.canal.vod.ext.third


import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import fr.canal.vod.ext.third.impl.DefaultThirdManager


@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array( "classpath:/third-beans.xml", "classpath:/third-beans-test.xml" ))
class DefaultThirdManagerTest {

  @Autowired
  var thirdManager: ThirdManager = _

  @Test
  def test() {
    thirdManager.third("test")
  }
}
