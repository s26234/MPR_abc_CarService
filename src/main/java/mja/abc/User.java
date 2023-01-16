package mja.abc;

public class User {
    private String accName;

    public User (String accName) {
        this.accName = accName;
    }

    public String getUser() {
        return accName;
    }

    @Override
    public String toString() {
        return "User{" +
                "accName='" + accName + '\'' +
                '}';
    }
}
