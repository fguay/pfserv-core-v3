package fr.canal.vod.sample.biz

import fr.canal.vod.api.exception.TechnicalException
import fr.canal.vod.sample.api.exception.SampleException
import fr.canal.vod.sample.api.dto.Sample

trait SampleBiz {

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  def jpaSample( param : String)  : Sample

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  def docSample( param : String)  : Sample

}

