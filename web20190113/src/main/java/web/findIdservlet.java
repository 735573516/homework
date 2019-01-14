package web;

import dao.StudentDao;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/findId")
public class findIdservlet extends HttpServlet {

    StudentDao studentDao = new StudentDao (); // 只有一个对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter ( "id" );
        int i = Integer.parseInt ( id );
        List<Student> list = studentDao.findById (i);
        req.setAttribute("list", list);
        req.getRequestDispatcher("findStudent.jsp").forward(req, resp);
    }
}
