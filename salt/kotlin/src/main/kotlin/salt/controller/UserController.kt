package salt.controller

// import java.util.List
import java.util.HashMap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import salt.entity.UserEntity
import salt.repository.UserRepository

@RestController
class UserController {

 @Autowired
 private val userRepos: UserRepository? = null

  @GetMapping("/api/description")
  fun descrip(): HashMap<String, String>? {
    return hashMapOf(
      "Classification" to "Fullstack",
      "Language" to "Kotlin",
      "Platform" to "JAX-RS",
      "Frontend" to "None/Jetty",
      "OS" to "Windows"
    )
  }

 @GetMapping("/api/user")
 fun user(): List<UserEntity>? {
   return userRepos?.findAll()
 }
}