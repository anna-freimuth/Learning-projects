package anna.hello_web.dto;

//Data transfer object
public class Greetings {

    public String name;
    public String greetings;

    public Greetings() {
    }

    public Greetings(String name, String greetings) {
        this.name = name;
        this.greetings = greetings;
    }

    @Override
    public String toString() {
        return greetings + " " + name;
    }
}
