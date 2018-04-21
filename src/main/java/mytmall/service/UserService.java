package mytmall.service;

import mytmall.pojo.User;
import mytmall.util.Page;

import java.util.List;

public interface UserService
{
    List<User> list(Page page);
    int total();
    User get(int id);
    boolean isExists(String userName);
    void add(User user);
    void setAnonyName(User user);
    User getByUserNameAndPassword(String name, String password);
}
