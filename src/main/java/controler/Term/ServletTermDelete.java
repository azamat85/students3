package controler.Term;

import database.DBManager;
import entity.Term;
import service.Services;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletTermDelete", value = "/delete-term")
public class ServletTermDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Term> allTerms = manager.getAllTerms();
        Term id = Services.getTermById(allTerms,request.getParameter("idSelectedTerm"));

//        String id =request.getParameter("deleteDisciplinHidden");

        manager.deletTerm(String.valueOf(id));
        response.sendRedirect("/termList");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
