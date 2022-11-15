package controler;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "CreatDisciplinesList", value = "/creat-disciplines")

public class CreatDisciplinesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/creatDisciplins.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        if (name.isEmpty()){
            request.setAttribute("erro",1);
            request.setAttribute("name",name);
            request.getRequestDispatcher("JSP/creatDisciplins.jsp").forward(request,response);
            return;
        }
        DBManager manager  =new DBManager();
        manager.creatDisciplins(name);

        response.sendRedirect("/disciplins");



    }
}
