package fr.canal.vod.sample.biz.impl

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import fr.canal.vod.api.exception.TechnicalException
import fr.canal.vod.sample.data.repo.{SampleDocumentRepository, SampleEntityRepository}
import fr.canal.vod.sample.data.entity.SampleEntity
import org.dozer.Mapper
import org.springframework.transaction.annotation.Transactional
import fr.canal.vod.sample.biz.SampleBiz
import fr.canal.vod.ext.third.ThirdManager
import fr.canal.vod.sample.data.doc.SampleDocument
import fr.canal.vod.sample.api.exception.SampleException
import fr.canal.vod.sample.api.dto.Sample

@Component("sampleBiz")
class DefaultSampleBiz() extends SampleBiz {

  @Autowired
  var thirdManager : ThirdManager = _

  @Autowired
  var sampleRepository : SampleEntityRepository = _

  @Autowired
  var sampleDocumentRepository : SampleDocumentRepository = _

  @Autowired
  var mapper: Mapper = _

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  @Transactional
  def jpaSample( param: String ) : Sample = {
    val third: String = thirdManager.third(param)
    var sampleEntity : SampleEntity = sampleRepository.findByName(third)
    if(sampleEntity == null)  {
      val rootEntity : SampleEntity = sampleRepository.findOne(1)
      sampleEntity = new SampleEntity()
      sampleEntity.setName(third)
      sampleEntity.setParent(rootEntity)
      sampleEntity = sampleRepository.save(sampleEntity)
    }
     mapper.map(sampleEntity , classOf[Sample])
  }

  @throws(classOf[TechnicalException])
  @throws(classOf[SampleException])
  @Transactional
  def docSample( param: String ) : Sample = {
    val third: String = thirdManager.third(param)
    var sampleDocument : SampleDocument =  sampleDocumentRepository.findByName(param)
    if(sampleDocument == null){
      val rootDocument : SampleDocument = sampleDocumentRepository.findOne("1")
      sampleDocument = new SampleDocument()
      sampleDocument.setName(third)
      sampleDocument.setParent(rootDocument)
      sampleDocumentRepository.save(sampleDocument)
    }
    mapper.map(sampleDocument, classOf[Sample])
  }

}