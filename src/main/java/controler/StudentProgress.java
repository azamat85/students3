package controler;

import database.DBManager;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentProgress", value = "/studentProgress")
public class StudentProgress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id2 = Integer.parseInt(req.getParameter("studentProgressHidden"));
        DBManager manager = new DBManager();
        Students student = manager.getSudentProgres(id2);
        req.setAttribute("students",student);
        req.getRequestDispatcher("JSP/studentProgress.jsp").forward(req,resp);
    }
}
