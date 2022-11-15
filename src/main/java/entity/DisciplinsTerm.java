package entity;

import java.util.Objects;

public class DisciplinsTerm {
    private int id;
    private String disciplineName;
    private String termName;

    public DisciplinsTerm() {
    }

    public DisciplinsTerm(int id, String disciplineName, String termName) {
        this.id = id;
        this.disciplineName = disciplineName;
        this.termName = termName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinsTerm that = (DisciplinsTerm) o;
        return id == that.id && Objects.equals(disciplineName, that.disciplineName) && Objects.equals(termName, that.termName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplineName, termName);
    }

    @Override
    public String toString() {
        return "DisciplinsTerm{" +
                "id=" + id +
                ", disciplineName='" + disciplineName + '\'' +
                ", termName='" + termName + '\'' +
                '}';
    }
}
