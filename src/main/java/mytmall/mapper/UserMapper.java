package mytmall.mapper;

import mytmall.pojo.User;
import mytmall.util.Page;

import java.util.List;

public interface UserMapper
{
    List<User> list(Page page);
    int total();
    User get(int id);
    void add(User user);
    User getByUserName(String userName);
    User getByUserNameAndPassword(String userName, String password);
}
