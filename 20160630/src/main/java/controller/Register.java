package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    public void init() throws ServletException {
        System.out.println("init()");
    }

    public void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        System.out.println("[info] account: " + account);
        System.out.println("[info] password: " + password);
        System.out.println("[info] password2: " + password2);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/zhongruan?useUnicode=true&characterEncoding=utf8",
                "root",
                "");
            stmt = conn.createStatement();
            String sql = "select count(*) counter "
                + "from yonghu "
                + "where zhanghao = '%s'";
            sql = String.format(sql, account, password);
            ResultSet rs = stmt.executeQuery(sql);
            int counter = 0;
            if (rs.next()) {
                System.out.println(rs.getInt("counter"));
                counter = rs.getInt("counter");
            }
            if (counter == 0) {
                sql = "insert into yonghu "
                    + "(zhanghao, mima, mingcheng) "
                    + "values ('%s', '%s', '%s')";
                sql = String.format(sql, account, password, account);
                stmt.executeUpdate(sql);
                System.out.println(sql);
            } else {
                System.out.println("账号已存在");
                out.println("ERROR_ACCOUNT_EXISTS");
                return;
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
        out.println("OK");
    }

    public void destroy() {
        super.destroy();
        System.out.println("destroy()");
    }
}
