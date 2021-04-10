package src.com.po;

import java.util.List;

public interface UserDao {
    List<User> getuserList();
    User getUserById(int id);
    User addUser(int id,String username,String pwd);
}
