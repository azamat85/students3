package controler.Disciplin;

import database.DBManager;
import entity.Disciplins;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="DisciplinModificationController", value = "/disciplinModificationController")

public class DisciplinModificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("modificationDisciplinHidden"));
        DBManager manager  =new DBManager();
        Disciplins disciplins = manager.getModifivationDisciplins(id) ;
        req.setAttribute("disciplins",disciplins);
        req.getRequestDispatcher("JSP/modificationDisciplins.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String id=req.getParameter("id");

        if (name.isEmpty()){
            req.setAttribute("erro",1);
            req.getRequestDispatcher("JSP/modificationDisciplins.jsp").forward(req,resp);
            return;
        }
        DBManager manager = new DBManager();
        manager.updateDisciplin(id,name);
        resp.sendRedirect("/disciplins");
    }
}
