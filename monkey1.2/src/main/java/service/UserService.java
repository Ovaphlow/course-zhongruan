package service;

import java.util.List;
import java.util.Map;

public interface UserService {

  void insert(String account, String password, String name);

  int lastId();

  List<Map<String, Object>> selectAll();
}