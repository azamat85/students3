package controler.Disciplin;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplinDeleteController", value = "/delete-disciplin")

public class DisciplinDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id1 =req.getParameter("deleteDisciplinHidden");
        DBManager manager = new DBManager();
        manager.deletDisciplin(id1);
        resp.sendRedirect("/disciplins");
    }

}
