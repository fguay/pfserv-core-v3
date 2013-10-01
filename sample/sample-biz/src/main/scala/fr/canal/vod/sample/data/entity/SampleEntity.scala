package fr.canal.vod.sample.data.entity

import javax.persistence._

import scala.beans.BeanProperty
import java.util
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "SAMPLE_TEST")
class SampleEntity {

    @Id
    @Column(name="ID", unique = true)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    @BeanProperty var id: java.lang.String = _

    @Basic
    @Column(name="VALUE")
    @BeanProperty var name: String = _

    @ManyToOne
    @JoinColumn(name="PARENT")
    @BeanProperty var parent: SampleEntity = _

    @OneToMany(mappedBy = "parent")
    @BeanProperty var childSample: util.List[SampleEntity] = _


}
