package controler.Term;

import database.DBManager;
import entity.Disciplins;
import entity.Term;
import service.Services;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCreatTerm", value = "/creat-term")
public class ServletCreatTerm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager  =new DBManager();
//        List<Term> term = manager.;
        List<Disciplins> disciplins = manager.getAllDisciplin();
//        ArrayList<Term> allTerms = manager.getAllTerms();
        request.setAttribute("disciplins",disciplins);
//        request.getSession().setAttribute("id",term);
//        Term idSelectedTerm = Services.getTermById(allTerms, request.getParameter("idSelectedTerm"));
        request.getRequestDispatcher("JSP/termCreating.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String duration=request.getParameter("duration");
        String id = request.getParameter("id");
        String id2 = request.getParameter("id");
        if (name.isEmpty()){
            request.setAttribute("erro",1);
            request.setAttribute("name",name);
            request.setAttribute("id",id);
//            request.setAttribute("id2",id2);
            request.setAttribute("duration",duration);
            request.getRequestDispatcher("JSP/termCreating.jsp").forward(request,response);
            return;
        }
        DBManager manager  =new DBManager();
        manager.creatTerm(name,duration);

        response.sendRedirect("/termList");

    }
}
