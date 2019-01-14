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

@WebServlet(urlPatterns = "/delete")
public class delete extends HttpServlet {
    StudentDao studentDao = new StudentDao ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentDao.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/deleteStudent.jsp").forward(req, resp);
    }
}
