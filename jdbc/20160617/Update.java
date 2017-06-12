import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/flight?useUnicode=true&characterEncoding=utf8",
                "root",
                "");
            stmt = conn.createStatement();
            String sql = "update weather_alt "
                + "set city = 'SHA'"
                + "where id = 33";
            long res = stmt.executeUpdate(sql);
            System.out.println("[info] update rows: " + String.valueOf(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
