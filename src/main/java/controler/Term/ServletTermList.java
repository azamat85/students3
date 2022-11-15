package controler.Term;

import database.DBManager;
import entity.Disciplins;
import entity.DisciplinsMark;
import entity.DisciplinsTerm;
import entity.Term;
import service.Services;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletTermList", value = "/termList")
public class ServletTermList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager  =new DBManager();
        List<Term> terms = manager.getAllTerms();
        ArrayList<Term> allTerms = manager.getAllTerms();
//        Term firstTerm =allTerms.get(0);

        Term firstTerm = null;
//        firstTerm=allTerms.get(0);
        if (request.getParameter("idSelectedTerm")==null){
            firstTerm=allTerms.get(0);
        }
        else {
            firstTerm= Services.getTermById(allTerms,request.getParameter("idSelectedTerm"));
        }
        ArrayList<DisciplinsTerm> allDisciplinsTerm = manager.getAllDisciplinsTerm(firstTerm);

        request.setAttribute("allTerms",allTerms);
        request.setAttribute("terms",terms);
        request.setAttribute("firstTerm",firstTerm);
        request.setAttribute("allDisciplinsTerm",allDisciplinsTerm);
        request.getRequestDispatcher("JSP/termList.jsp").forward(request,response);



    }


}
