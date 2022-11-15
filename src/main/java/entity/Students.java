package entity;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Objects;

public class Students {
    private int id;
    private String name;
    private String surname;
    private String group;
    private Date date;
    private byte status;

    public Students() {
    }

    public Students(int id, String name, String surname, String group, Date date, byte status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && status == students.status && Objects.equals(name, students.name) && Objects.equals(surname, students.surname) && Objects.equals(group, students.group) && Objects.equals(date, students.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, group, date, status);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
