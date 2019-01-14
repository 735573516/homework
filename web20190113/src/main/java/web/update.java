package web;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/update")
public class update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt ( req.getParameter ( "id" ) );
            String name = req.getParameter ( "name" );
            String birthday = req.getParameter ( "birthday" );
            String sex = req.getParameter ( "sex" );
            Date bir = new SimpleDateFormat ( "yyyy-MM-dd" ).parse ( birthday );
            Student stu = new Student ( );
            stu.setSid ( id );
            stu.setSname ( name );
            stu.setBirthday ( bir );
            stu.setSex ( sex );
            StudentDao dao = new StudentDao ( );
            dao.update ( stu );
            List <Student> list = dao.findById ( id );
            req.setAttribute("list", list);
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        } catch (ParseException e) {
            e.printStackTrace ( );
        }
    }
}
