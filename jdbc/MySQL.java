import java.sql.*;
import java.util.*;

public class MySQL {
    // private String dbUser = "cmtech";
    // private String dbPassword = "cmtech.1123";
    private String dbHost = "jdbc:mysql://"
        + GVars.DB_SERVER
        + ":3306/"
        + GVars.DB_NAME
        + "?useUnicode=true&characterEncoding=utf8";
    private String dbDriver = "com.mysql.jdbc.Driver";

    private Connection cnx;
    private Statement stmt;

    private boolean initDB() {
        try {
            Class.forName(dbDriver).newInstance();
            cnx = DriverManager.getConnection(dbHost, GVars.DB_USER, GVars.DB_PASSWORD);
            stmt = cnx.createStatement();
        } catch (Exception ex) {
            // System.out.println(ex);
            System.out.println(String.format("数据库连接失败 --%s", ex));
            return false;
        }
        return true;
    }

    public Map<String, Object> fetchOne(String sqlText) {
        ResultSet rs;
        if (!initDB()) {
            return null;
        }
        Map<String, Object> row = new LinkedHashMap<String, Object>();
        try {
            rs = stmt.executeQuery(sqlText);
            rs.first();
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
              row.put(meta.getColumnName(i), rs.getObject(i));
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(String.format("查询单条数据出错 --%s \n错误信息 --%s", sqlText, e));
        }
        closeDB();
        return row;
    }

    public List<Map<String, Object>> fetchAll(String sqlText) {
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        ResultSet rs;
        if (!initDB()) {
            return null;
        }
        try {
            rs = stmt.executeQuery(sqlText);
            while(rs.next()) {
                Map<String, Object> row = new LinkedHashMap<String, Object>();
                ResultSetMetaData meta = rs.getMetaData();
                for (int i = 1; i <= meta.getColumnCount(); i++)
                row.put(meta.getColumnName(i), rs.getObject(i));
                rows.add(row);
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(String.format("查询多条数据出错 --%s \n错误信息 --%s", sqlText, e));
        }
        closeDB();
        return rows;
    }

    public boolean execute(String sqlText) {
        if (!initDB()) {
            return false;
        }
        try {
            stmt.executeUpdate(sqlText);
        } catch (Exception e) {
            System.out.println(String.format("执行SQL出错 --%s \n错误信息 --%s", sqlText, e));
            return false;
        }
        closeDB();
        return true;
    }

    public String insert(String sqlText) {
        if (!initDB()) {
            return null;
        }
        String sql = "select LAST_INSERT_ID() as lastId";
        String lastId = "0";
        ResultSet res;
        try {
            stmt.executeUpdate(sqlText);
            res = stmt.executeQuery(sql);
            res.first();
            lastId = res.getString("lastId");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(String.format("添加数据出错 --%s \n错误信息 --%s", sqlText, e));
            return null;
        }
        closeDB();
        return lastId;
    }

    private void closeDB() {
        if (stmt != null) {
            try {
              stmt.close();
            } catch (SQLException sqlEx) { }
            stmt = null;
        }
        try {
            cnx.close();
        } catch (Exception ex) {}
    }
}

