package fr.canal.vod.sample.ws.impl

import javax.ws.rs.Path
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import fr.canal.vod.sample.biz.SampleBiz
import fr.canal.vod.api.sample.dto.Sample
import fr.canal.vod.ws.SampleWebService

@Path("/sample")
@Component("sampleService")
class SampleWebServiceImpl extends SampleWebService(){

  @Autowired
  var sampleManager: SampleBiz = null

  def sample(param : String) : Sample = {
     sampleManager.sample(param);
  }

}