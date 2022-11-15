package controler;

import database.DBManager;
import entity.DisciplinsMark;
import entity.Students;
import entity.Term;
import service.Services;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "ServletProgressController", value = "/student-progress")
public class ServletProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        Students student = manager.getStudentsById(request.getParameter("progressStudentHidden"));
        ArrayList<Term> allTerms = manager.getAllTerms();
        Term firstTerm = null;
//        firstTerm=allTerms.get(0);
        if (request.getParameter("idSelectedTerm")==null){
          firstTerm=allTerms.get(0);
        }
        else {
            firstTerm= Services.getTermById(allTerms,request.getParameter("idSelectedTerm"));
        }
        ArrayList<DisciplinsMark> allDisciplinsMark = manager.getAllDisciplinsMark(student, firstTerm);

        double aMark = Services.getAverageMark(allDisciplinsMark);

        request.setAttribute("student",student);
        request.setAttribute("allTerms",allTerms);
        request.setAttribute("firstTerm",firstTerm);
        request.setAttribute("aMark",aMark);
        request.setAttribute("allDisciplinsMark",allDisciplinsMark);
        request.getRequestDispatcher("JSP/student-progress.jsp").forward(request,response);


    }
}
