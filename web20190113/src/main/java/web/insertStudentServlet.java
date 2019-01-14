package web;

import dao.StudentDao;
import domain.Student;
import util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns ="/insertStudent")
public class insertStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter ( "name" );
            String birthday = req.getParameter ( "birthday" );
            String sex = req.getParameter ( "sex" );
            Date bir = new SimpleDateFormat ( "yyyy-MM-dd" ).parse ( birthday );
            Student student = new Student ( );
            student.setSid ( JdbcUtils.getind () );
            student.setSname ( name );
            student.setBirthday ( bir );
            student.setSex ( sex );
            new StudentDao ().insert ( student );
            List<Student> list=new ArrayList <> (  );
            list.add ( student );
            req.setAttribute ( "list",list );
            req.getRequestDispatcher ( "/insertresult.jsp" ).forward ( req,resp );
        } catch (ParseException e) {
            e.printStackTrace ( );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
}
