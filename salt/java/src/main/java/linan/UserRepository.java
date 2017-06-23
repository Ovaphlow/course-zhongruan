package linan;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

  User findById(Long id);

  List<User> findByAccount(String account);

  List<User> findAll();

  @Query(value="select * from user where id > :id", nativeQuery = true)
  List<User> fix(@Param("id") Long id);

//  @Query(value="select * from user where id > ?1", nativeQuery = true)
//  List<User> fix(Long id);
}
