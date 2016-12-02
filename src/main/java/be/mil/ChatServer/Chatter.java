package be.mil.ChatServer;

/**
 * Created by benoit on 30/11/2016.
 */
public class Chatter {

    private int id;
    private String name;

    public Chatter() {
    }

    public Chatter(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatter)) return false;

        Chatter chatter = (Chatter) o;

        return getId() == chatter.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }
}
