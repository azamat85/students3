package entity;

import java.util.Objects;

public class Disciplins {
    private int id;
    private String name;
    private byte status;

    public Disciplins() {
    }

    public Disciplins(int id, String name, byte status) {
        this.id = id;
        this.name = name;
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
        Disciplins that = (Disciplins) o;
        return id == that.id && status == that.status && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }

    @Override
    public String toString() {
        return "Disciplins{" +
                "id=" + id +
                ", disciplinName='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
