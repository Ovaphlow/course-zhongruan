package linan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

  @Autowired
  UserRepository userRepos;

  @GetMapping("/api/description")
  @ResponseBody
  public Map<String, String> description() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("Classification", "Fullstack");
    result.put("Language", "Java");
    result.put("Platform", "JAX-RS");
    result.put("Frontend", "None/Jetty");
    result.put("OS", "Windows");
    return result;
  }

  @GetMapping("/api/user")
  @ResponseBody
  public List<User> user() {
    return userRepos.findAll();
  }
}
