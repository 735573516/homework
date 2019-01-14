package dao;

import domain.Student;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// 数据访问对象
public class StudentDao {

    // 查询所有
    public List<Student> findAll() {
        try(Connection conn = JdbcUtils.getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement("select * from student")){
                ResultSet rs = stmt.executeQuery();
                List<Student> list = new ArrayList<>();
                while(rs.next()) {
                    Student stu = new Student ();
                    stu.setSid(rs.getInt("sid"));
                    stu.setSname(rs.getString("sname"));
                    stu.setBirthday(rs.getDate("birthday"));
                    stu.setSex(rs.getString("sex"));
                    list.add(stu);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    // 添加学生
    public void insert(Student student) {
        try(Connection conn = JdbcUtils.getConnection()){
            String birthday = new SimpleDateFormat ( "yyyy-MM-dd" ).format ( student.getBirthday () );
            String sname = student.getSname ( );
            String sex = student.getSex ( );
            PreparedStatement psmt = conn.prepareStatement ( "insert into student(sname,birthday,sex) values (\'" + sname + "\',\'"
                    + birthday + "\',\'" + sex + "\');" );
            psmt.executeUpdate ();
        }catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
    // 根据 id 查询
    public List<Student> findById(int sid) {
        try(Connection conn = JdbcUtils.getConnection()) {
            try(PreparedStatement stmt = conn.prepareStatement("select * from student where sid="
                    +sid)){
                ResultSet rs = stmt.executeQuery();
                List<Student> list = new ArrayList<>();
                while(rs.next()) {
                    Student stu = new Student ();
                    stu.setSid(rs.getInt("sid"));
                    stu.setSname(rs.getString("sname"));
                    stu.setBirthday(rs.getDate("birthday"));
                    stu.setSex(rs.getString("sex"));
                    list.add(stu);
                }
                return list ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }


    }
    // 修改学生
    public void update(Student student) {
        try (Connection conn=JdbcUtils.getConnection ()){
            Integer sid = student.getSid ( );
            String sname = student.getSname ( );
            Date bir = student.getBirthday ( );
            String sex = student.getSex ( );
            String birthday = new SimpleDateFormat ( "yyyy-MM-dd" ).format ( bir );
            String str="update student set sname=\'"+sname+"\',birthday=\'"+birthday+"\',sex=\'"
                    +sex+"\' where sid="+sid;
            PreparedStatement psmt = conn.prepareStatement ( str );
            psmt.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
    // 删除学生
    public void delete(String sid) {
        try (Connection conn=JdbcUtils.getConnection ()){
            PreparedStatement psmt = conn.prepareStatement ( "delete from student where sid=" + sid );
            int i = psmt.executeUpdate ( );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
}
