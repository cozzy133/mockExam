package ie.gmit;
/*
    Student class

    Padraig Ó Cosgora
    G00311302
    21/02/2020
 */
public class Student {

    private String name;
    private String email;

    public Student() {
        this.name = "";
        this.email = "";
    }

    public Student(String name, String email) {
        if ((name.length() < 3) || (!email.contains("@"))) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.email = email;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException();
        } else {
            this.email = email;
        }
    }
}