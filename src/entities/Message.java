package entities;

public class Message {
    private final Long id;
    private final String data;

    public Message(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}
