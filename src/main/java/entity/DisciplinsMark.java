package entity;

import java.util.Objects;

public class DisciplinsMark {
    private int id;
    private String disciplineName;
    private String markName;

    public DisciplinsMark() {
    }

    public DisciplinsMark(int id, String disciplineName, String markName) {
        this.id = id;
        this.disciplineName = disciplineName;
        this.markName = markName;
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

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinsMark that = (DisciplinsMark) o;
        return id == that.id && Objects.equals(disciplineName, that.disciplineName) && Objects.equals(markName, that.markName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplineName, markName);
    }

    @Override
    public String toString() {
        return "DisciplinsMark{" +
                "id=" + id +
                ", disciplineName='" + disciplineName + '\'' +
                ", markName='" + markName + '\'' +
                '}';
    }
}
