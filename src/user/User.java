package user;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private int age;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public User(String id, String name, String email, String password, int age, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    @Override
    public String toString(){
        return "=======Profile=======\n" +
                "ID          : " + id + "\n" +
                "Name        : " + name + "\n" +
                "Email       : " + email + "\n" +
                "Role        : " + role + "\n" +
                "Age         : " + age + "\n";
    }
}
