package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import entity.BizCardEntity;

public interface BizCardDao{
  List<BizCardEntity> list();

  List<Map<String, Object>> listWithPhone();

  List<Map<String, Object>> search(@Param("keyword") String keyword);
}
