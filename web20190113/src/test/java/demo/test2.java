package demo;

import dao.StudentDao;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class test2 {
    public static void main(String[] args) {
        try(Connection conn = JdbcUtils.getConnection()){
            String birthday = "1996-12-26";
            String sname = "liangqiu";
            String sex = "男";
            PreparedStatement psmt = conn.prepareStatement ( "insert into student(sname,birthday,sex) values (\'" + sname + "\',\'"
                    + birthday + "\',\'" + sex + "\');" );
            psmt.executeUpdate ();
        }catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
}
