import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
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
            String sql = "select * "
                + "from weather_alt";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("[%s] %s - %s\r\n",
                    rs.getInt("id"),
                    rs.getString("date"),
                    rs.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
