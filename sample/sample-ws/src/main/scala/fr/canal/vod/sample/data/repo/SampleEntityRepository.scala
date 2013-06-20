package fr.canal.vod.sample.data.repo

import org.springframework.stereotype.Repository
import fr.canal.vod.sample.data.entity.SampleEntity
import org.springframework.data.repository.CrudRepository
import fr.canal.vod.api.sample.dto.Sample
;

@Repository
trait SampleEntityRepository extends CrudRepository[SampleEntity, Integer] {

  def findByName(name: String) : SampleEntity

}
