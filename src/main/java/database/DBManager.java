package database;

import constans.Constant;
import entity.*;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Students> getAllStudents() {
        ArrayList<Students> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from students where status=1;");
            while (rs.next()) {
                Students student = new Students();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(rs.getByte("status"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Students getStudentsById(String id) {
        Students student = new Students();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from students where id ="+id+";");
            while (rs.next()) {

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(rs.getByte("status"));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public ArrayList<Disciplins> getAllDisciplin() {
        ArrayList<Disciplins> disciplins = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from distplin where status=1;");
            while (rs.next()) {
                Disciplins disciplin = new Disciplins();
                disciplin.setId(rs.getInt("id"));
                disciplin.setName(rs.getString("name"));
                disciplin.setStatus(rs.getByte("status"));
                disciplins.add(disciplin);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return disciplins;
    }

    @Override
    public Students getModifivationStudent(int id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from students where status=1 and id=" + id + ";");
            while (rs.next()) {
                Students student = new Students();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(rs.getByte("status"));
                return student;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Disciplins getModifivationDisciplins(int id3) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from distplin where status=1 and id=" + id3 + ";");
            while (rs.next()) {
                Disciplins disciplins = new Disciplins();
                disciplins.setId(rs.getInt("id"));
                disciplins.setName(rs.getString("name"));
                disciplins.setStatus(rs.getByte("status"));
                return disciplins;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public void creatStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `students` (`name`, `surname`, `group`, `date`) VALUES ('" + name + "', '" + surname + "', '" + group + "', '" + date + "') ;");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void creatDisciplins(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `distplin` (`name`, `status`) VALUES ('"+name+"', '1');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void creatTerm(String name,String duration) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `term` (`name`, `duration`, `status`) VALUES ('"+name+"', '"+duration+"', '1');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateTerm(String idT, String idD) {

    }

    @Override
    public void updateStudent(String id, String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students3`.`students` SET `name` = '" + name + "', `surname` = '" + surname + "', `group` = '" + group + "', `date` = '" + date + "' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateDisciplin(String id, String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students3`.`distplin` SET `name` = '" + name + "' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletStudents(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students` SET `status` = '0' WHERE (`id` in(" + ids + "));");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deletDisciplin(String id1) {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
        Statement stmt = con.createStatement();
        stmt.execute("UPDATE `distplin` SET `status` = '0' WHERE (`id` in(" + id1 + "));");

    } catch (Exception e) {
        throw new RuntimeException(e);
    }


    }

    @Override
    public void deletTerm(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `term` SET `status` = '0' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Students getSudentProgres( int id2) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            stmt.execute("select name, surname, date from students where status=1 and id = "+id2+" ;");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Term> getAllTerms() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from term where status=1 order by name;");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName(rs.getString("name"));
                term.setDuration(rs.getInt("duration"));
                term.setStatus(rs.getByte("status"));
                terms.add(term);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return terms;
    }

    @Override
    public ArrayList<DisciplinsMark> getAllDisciplinsMark(Students s, Term t) {
        ArrayList<DisciplinsMark> dm = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.id, d.name distplin_name , m.name from distplin d \n" +
                    "left join term_discplin td on td.id_discplin = d.id\n" +
                    "left join students_term_distplin_mark stdm on stdm.id_term_di=td.id\n" +
                    "left join mark m on m.id=stdm.id_mark\n" +
                    "where td.id_term="+t.getId()+" and \n" +
                    "(stdm.id_student = "+s.getId()+" or stdm.id_student is null);");
            while (rs.next()) {
                DisciplinsMark disciplinsMark = new DisciplinsMark();
                disciplinsMark.setId(rs.getInt("id"));
                disciplinsMark.setDisciplineName(rs.getString("distplin_name"));
                disciplinsMark.setMarkName(rs.getString("name"));

                dm.add(disciplinsMark);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dm;
    }

    @Override
    public ArrayList<DisciplinsTerm> getAllDisciplinsTerm( Term t) {
        ArrayList<DisciplinsTerm> dt = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.name from term_discplin as td \n" +
                    "join distplin d on td.id_discplin=d.id\n" +
                    "join term t on td.id_term=t.id \n" +
                    "where td.id_term="+t.getId()+";");
            while (rs.next()) {
                DisciplinsTerm disciplinsTerm = new DisciplinsTerm();
//                disciplinsTerm.setId(rs.getInt("id"));
                disciplinsTerm.setDisciplineName(rs.getString("name"));


                dt.add(disciplinsTerm);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dt;
    }

    @Override
    public ArrayList<Role> getAllRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from new_table;");
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));



                roles.add(role);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return roles;
    }


    @Override
    public boolean chekLogin(String login, String password, String role) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constant.CONNECTION_URL_DB, Constant.CONNECTION_LOGIN_DB, Constant.CONNECTION_PASSWORD_DB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select 1 from user u \n" +
                    "join user_role ur on ur.user_id=u.id\n" +
                    "where login = '"+login+"' and password = '"+password+"' and role_id = "+role);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}




