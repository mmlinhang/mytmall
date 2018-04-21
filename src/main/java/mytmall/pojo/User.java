package mytmall.pojo;

public class User
{
    private int id;
    private String userName;
    private String password;

    private String anonyName;

    public String getAnonyName() {
        return anonyName;
    }

    public void setAnonyName(String anonyName) {
        this.anonyName = anonyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
