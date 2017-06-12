import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {
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
            stmt.executeUpdate("insert into weather_alt ("
                + "id, date, city, flag"
                + ") values ("
                + "0, '2016-06-20', 'HRB', 1"
                + ")");
            ResultSet rs = stmt.executeQuery("select last_insert_id()");
            int lastId = 0;
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
            System.out.println("[info] lastId: " + String.valueOf(lastId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
