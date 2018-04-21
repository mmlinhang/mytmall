package mytmall.service.impl;

import mytmall.mapper.UserMapper;
import mytmall.pojo.User;
import mytmall.service.UserService;
import mytmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.List;
import java.util.regex.Matcher;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    public List<User> list(Page page)
    {
        return userMapper.list(page);
    }

    public int total()
    {
        return userMapper.total();
    }

    public User get(int id)
    {
        return userMapper.get(id);
    }

    public boolean isExists(String userName)
    {
        User user = userMapper.getByUserName(userName);
        if(user == null)
            return false;
        else
            return true;
    }

    public void add(User user)
    {
        userMapper.add(user);
    }

    public void setAnonyName(User user)
    {
        String userName = user.getUserName();

        Pattern pattern;
        Matcher matcher;

        if(userName.length() == 1)
            userName = "*";
        else if(userName.length() == 2)
        {
            pattern = Pattern.compile(".$");
            matcher = pattern.matcher(userName);
            userName = matcher.replaceFirst("*");
        }
        else
        {
            pattern = Pattern.compile("^.(.+).$");
            matcher = pattern.matcher(userName);
            if(matcher.find())
            {
                String old = matcher.group(1);

                pattern = Pattern.compile(".");
                matcher = pattern.matcher(old);
                String r = matcher.replaceAll("*");

                userName = userName.replace(old, r);
            }
        }

        user.setAnonyName(userName);
    }

    @Override
    public User getByUserNameAndPassword(String name, String password) {
        return userMapper.getByUserNameAndPassword(name, password);
    }
}
