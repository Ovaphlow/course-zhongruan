package action;

import java.time.LocalTime;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport {
    private String account;
    private String password;
    private String foo;

    public String loginPost() throws Exception {
        return SUCCESS;
    }

    public String login() throws Exception {
        System.out.println(String.format("[INFO] %s - 账号 %s", LocalTime.now(), account));
        System.out.println(String.format("[INFO] %s - 密码 %s", LocalTime.now(), password));
        if ("admin".equals(account)) {
            return ERROR;
        }
        setFoo("系统登录");
        return SUCCESS;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
