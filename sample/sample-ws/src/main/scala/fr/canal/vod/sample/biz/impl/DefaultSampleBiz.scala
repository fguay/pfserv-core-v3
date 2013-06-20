package fr.canal.vod.sample.biz.impl

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.{Qualifier, Autowired}
import fr.canal.vod.api.exception.TechnicalException
import fr.canal.vod.api.sample.exception.SampleException
import fr.canal.vod.api.sample.dto.Sample
import fr.canal.vod.sample.data.repo.SampleEntityRepository
import fr.canal.vod.sample.data.entity.SampleEntity
import org.dozer.Mapper
import org.springframework.transaction.annotation.Transactional
import fr.canal.vod.sample.biz.SampleBiz
import fr.canal.vod.ext.third.ThirdManager

@Component("sampleBiz")
class DefaultSampleBiz() extends SampleBiz {

  @Autowired
  var thirdManager : ThirdManager = _

  @Autowired
  var sampleRepository : SampleEntityRepository = _

  @Autowired
  var mapper: Mapper = _

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  @Transactional
  def sample( param: String ) : Sample = {
    val third: String = thirdManager.third(param)
    var sampleEntity : SampleEntity = sampleRepository.findByName(third)
    if(sampleEntity == null)  {
      val rootEntity : SampleEntity = sampleRepository.findOne(1)
      sampleEntity = new SampleEntity()
      sampleEntity.setName(third);
      sampleEntity.setParent(rootEntity)
      sampleEntity = sampleRepository.save(sampleEntity)
    }
     mapper.map(sampleEntity , classOf[Sample])
  }

}

