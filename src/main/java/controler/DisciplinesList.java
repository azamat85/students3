package controler;


import database.DBManager;
import entity.Disciplins;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="disciplins", value = "/disciplins")

public class DisciplinesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager  =new DBManager();
        List<Disciplins> disciplins = manager.getAllDisciplin();
        req.setAttribute("disciplins",disciplins);
        req.getRequestDispatcher("JSP/disciplinesList.jsp").forward(req,resp);
    }
}
