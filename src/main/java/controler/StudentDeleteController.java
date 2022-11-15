package controler;

import constans.Constant;
import database.DBManager;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "StudentDeleteController" , value = "/delete-student")

public class StudentDeleteController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("deleteStudentHidden");
        DBManager manager = new DBManager();
        manager.deletStudents(ids);
        resp.sendRedirect("/students");

    }

}
