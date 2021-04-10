package src.com.test;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import src.com.po.User;

import java.util.List;


public class TestUser {

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();
        List<User> list = sqlSession.selectList("com.mapper.UserMapper.getUserById");
        for (User user: list){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        User user = new User();
        user.setId(12);
        user.setUsername("liaojinhu");
        user.setPassword("654987");
        int row = sqlSession.insert("com.mapper.UserMapper.addUser",user);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        int row = sqlSession.delete("com.mapper.UserMapper.deleteUser",11);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }
}
