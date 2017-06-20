package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DangAnDao {

  List<Map<String, Object>> search(@Param("keyword") String keyword);

  List<Map<String, Object>> list();
}
