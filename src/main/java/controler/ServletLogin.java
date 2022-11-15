package controler;

import database.DBManager;
import entity.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Role> allRoles = manager.getAllRoles();
        request.setAttribute("allRoles",allRoles);
        request.getRequestDispatcher("JSP/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Role> allRoles = manager.getAllRoles();
        request.setAttribute("allRoles",allRoles);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if (login.isEmpty()||password.isEmpty()||role.isEmpty()){
            request.setAttribute("Error",1);
            request.getRequestDispatcher("JSP/creat-student.jsp").forward(request,response);
            return;
        }

        if (manager.chekLogin(login,password,role)){
            request.getSession().setAttribute("isLogin",1);
            request.getSession().setAttribute("login",login);
            request.getSession().setAttribute("role",role);
            response.sendRedirect("/login");

        }
        else {
            request.setAttribute("erro",1);
            request.getRequestDispatcher("JSP/login.jsp").forward(request,response);
        }



    }
}
