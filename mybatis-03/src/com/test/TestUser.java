package src.com.test;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import src.com.po.User;


public class TestUser {

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();
        User user = sqlSession.selectOne("com.mapper.UserMapper.getUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        User user = new User();
        user.setId(6);
        user.setUsername("liaojinhu");
        user.setPwd("654987");
        int row = sqlSession.insert("com.mapper.UserMapper.addUser",user);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        int row = sqlSession.delete("com.mapper.UserMapper.deleteUser",4);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }
}
