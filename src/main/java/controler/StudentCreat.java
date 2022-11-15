package controler;

import database.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentCreat", value = "/creat-student")
public class StudentCreat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/creat-student.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String surname=request.getParameter("surname");
        String name=request.getParameter("name");
        String group=request.getParameter("group");
        String dateFronUser=request.getParameter("date");
        if (surname.isEmpty()||name.isEmpty()||group.isEmpty()||dateFronUser.isEmpty()){
            request.setAttribute("erro",1);
            request.setAttribute("surname",surname);
            request.setAttribute("name",name);
            request.setAttribute("group",group);
            request.setAttribute("date",dateFronUser);
            request.getRequestDispatcher("JSP/creat-student.jsp").forward(request,response);
            return;
        }

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateFronUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateToBD = formatter.format(date);

        DBManager manager  =new DBManager();
        manager.creatStudent(surname,name,group,dateToBD);

        response.sendRedirect("/students");



    }
}
