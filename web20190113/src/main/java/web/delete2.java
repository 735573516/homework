package web;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete2")
public class delete2 extends HttpServlet {
    StudentDao Dao = new StudentDao ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter ( "id" );
        Dao.delete ( id );
        req.setAttribute("list", null);
        req.getRequestDispatcher("/deleteRs.jsp").forward(req, resp);
    }
}
