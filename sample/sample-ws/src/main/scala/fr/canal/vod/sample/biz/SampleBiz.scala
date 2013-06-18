package fr.canal.vod.sample.biz

import fr.canal.vod.api.exception.TechnicalException
import fr.canal.vod.api.sample.exception.SampleException
import fr.canal.vod.api.sample.dto.Sample


trait SampleBiz {

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  def sample( param : String)  : Sample

}

