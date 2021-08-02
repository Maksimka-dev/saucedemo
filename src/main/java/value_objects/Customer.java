package value_objects;

public class Customer {
    private String firstName;
    private String lastName;
    private Integer postalCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public Customer(String firstName, String lastName, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
}
