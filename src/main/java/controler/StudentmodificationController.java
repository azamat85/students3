package controler;

import database.DBManager;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "StudentmodificationController", value = "/modificationStudent")
public class StudentmodificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("modificationStudentsHidden"));
        DBManager manager  =new DBManager();
        Students student = manager.getModifivationStudent(id);
        req.setAttribute("students",student);
        req.getRequestDispatcher("JSP/modificationStudent.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String surname=request.getParameter("surname");
        String name=request.getParameter("name");
        String group=request.getParameter("group");
        String dateFronUser=request.getParameter("date");
        String id=request.getParameter("id");

        if (surname.isEmpty()||name.isEmpty()||group.isEmpty()||dateFronUser.isEmpty()){
            request.setAttribute("erro",1);
            request.setAttribute("surname",surname);
            request.setAttribute("name",name);
            request.setAttribute("group",group);
            request.setAttribute("date",dateFronUser);
            request.getRequestDispatcher("JSP/creat-student.jsp").forward(request,response);
            return;
        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse(dateFronUser, formatter);

//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//        Date date = null;
//        try {
//            date = format.parse(dateFronUser);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

//        Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//        String dateToBD = formatter1.format(date);


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
        manager.updateStudent(id, surname,  name,  group, dateToBD);

        response.sendRedirect("/students");



    }
}
