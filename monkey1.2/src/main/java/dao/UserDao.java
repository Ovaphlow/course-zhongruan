package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
  @Select(
      "select count(*) counter, id "
      + "from user "
      + "where account = #{account} "
      + "and password = #{password} "
      + "limit 1"
  )
  Map<String, Object> login(
    @Param("account") String account,
    @Param("password") String password
  );

  List<Map<String, Object>> selectAll();

  void insert(
    @Param("account") String account,
    @Param("password") String password,
    @Param("name") String name
  );

  int lastId();
}
