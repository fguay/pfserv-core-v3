package fr.canal.vod.sample.data.repo

import org.springframework.stereotype.Repository
import fr.canal.vod.sample.data.entity.SampleEntity
import org.springframework.data.repository.CrudRepository

@Repository
trait SampleEntityRepository extends CrudRepository[SampleEntity, String] {

  def findByName(name: String): SampleEntity

}
