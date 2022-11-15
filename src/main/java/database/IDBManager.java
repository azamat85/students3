package database;

import entity.*;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Students> getAllStudents();
    Students getStudentsById(String id);
    ArrayList<Disciplins> getAllDisciplin();
    Students getModifivationStudent( int id);
    Disciplins getModifivationDisciplins( int id3);
    void creatStudent(String surname, String name, String group, String date);
    void creatDisciplins(String name);
    void creatTerm(String name,String duration);
    void updateTerm(String idT,String idD);
    void updateStudent(String id,String surname, String name, String group, String date);
    void updateDisciplin(String id, String name);
    void deletStudents(String ids);
    void deletDisciplin(String id1);
    void deletTerm(String id);
    Students getSudentProgres( int id2);
    ArrayList<Term> getAllTerms();
    ArrayList<DisciplinsMark> getAllDisciplinsMark(Students s, Term t);
    ArrayList<DisciplinsTerm> getAllDisciplinsTerm(Term t);
    ArrayList<Role> getAllRoles();
    boolean chekLogin(String login,String password,String role);




}
