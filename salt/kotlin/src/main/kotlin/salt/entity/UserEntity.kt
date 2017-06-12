package salt.entity

import java.io.Serializable
import javax.persistence.*

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name="user")
data class UserEntity(
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  var id: Long? = 0,

  @Column(nullable=false)
  var name: String? = null,

  @Column(nullable=false)
  var account: String? = null,

  @JsonIgnore
  @Column(nullable=false)
  var password: String? = null
) : Serializable {
  protected constructor() : this(id=null, name=null, account=null, password=null) {}
}