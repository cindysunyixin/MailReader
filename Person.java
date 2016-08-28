/**
* This class creates a person Object.
* @author Yixin Sun
* @version 1.0
*/
public class Person implements Comparable<Person> {
    private String name;
    private String email;
/**Constructor for Person
@param name name
@param email email
*/
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Person)) {
            return true;
        }
        Person that = (Person) other;
        return this.name.equals(that.name)
            && this.email.equals(that.email);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = result * 17 + name.hashCode();
        result = result * 17 + email.hashCode();
        return result;
    }
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
/**
This method returns name
@return name
*/
    public String getName() {
        return name;
    }
/**
This method returns email
@return email
*/
    public String getEmail() {
        return email;
    }
}
