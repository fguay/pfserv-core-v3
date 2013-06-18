package fr.canal.vod.sample.data.entity

import javax.persistence._
import java.util.List

import fr.canal.vod.api.sample.dto.Sample
import org.codehaus.jackson.annotate.{JsonManagedReference, JsonBackReference}
import scala.beans.BeanProperty

@Entity
@Table(name = "SAMPLE")
class SampleEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @BeanProperty var id: Integer = _

    @Basic
    @Column(name="VALUE")
    @BeanProperty var name: String = _

    @ManyToOne
    @JoinColumn(name="PARENT")
    @BeanProperty var parent: SampleEntity = _

    @OneToMany(mappedBy = "parent")
    @BeanProperty var childSample: List[SampleEntity] = _


}
