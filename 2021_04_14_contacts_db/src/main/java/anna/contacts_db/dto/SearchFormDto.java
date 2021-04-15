package anna.contacts_db.dto;

public class SearchFormDto {

    private final String name;
    private final String lastName;

    public SearchFormDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
