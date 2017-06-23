package linan;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, length=50)
  private String account;

  @Column(nullable=false, length=50)
  private String password;

  @Column(nullable=false, length=50)
  private String name;

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String passwrod) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", account='" + account + '\'' +
      ", password='" + password + '\'' +
      ", name='" + name + '\'' +
      '}';
  }
}
