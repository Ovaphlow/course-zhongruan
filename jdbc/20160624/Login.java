import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String account = "lisi12";
        String password = "wangwu";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/zhongruan?useUnicode=true&characterEncoding=utf8",
                "root",
                "");
            stmt = conn.createStatement();
            String sql = "select count(*) counter "
                + "from yonghu "
                + "where zhanghao = '%s' "
                + "and mima = '%s'";
            sql = String.format(sql, account, password);
            ResultSet rs = stmt.executeQuery(sql);
            int counter = 0;
            if (rs.next()) {
                counter = rs.getInt("counter");
            }
            System.out.println(counter);
            if (counter == 0) {
                System.out.println("error");
            } else {
                System.out.println("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
