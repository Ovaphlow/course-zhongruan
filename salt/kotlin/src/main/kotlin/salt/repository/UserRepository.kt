package salt.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

import salt.entity.UserEntity

@Transactional
interface UserRepository : CrudRepository<UserEntity, Long> {
  fun findByAccount(account: String): UserEntity?
  override fun findAll(): List<UserEntity>?
}