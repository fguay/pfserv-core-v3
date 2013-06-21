package fr.canal.vod.sample.data.entity

import javax.persistence._
import java.util.List

import scala.beans.BeanProperty
import java.util

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
    @BeanProperty var childSample: util.List[SampleEntity] = _


}
