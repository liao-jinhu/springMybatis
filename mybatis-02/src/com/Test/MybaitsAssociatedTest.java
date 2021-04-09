package src.com.Test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import src.com.po.Person;

public class MybaitsAssociatedTest {
    @Test
    public  void findPersonByIdTest(){
        SqlSession sqlSession= MybatisUtils2.getSession();
        Person person = sqlSession.selectOne("com.mapper.PersonMapper.findPersonId",1);
        System.out.println(person);
        sqlSession.close();
    }

    @Test
    public  void findPersonByIdTest2(){
        SqlSession sqlSession= MybatisUtils2.getSession();
        Person person = sqlSession.selectOne("com.mapper.PersonMapper.findPersonId2",1);
        System.out.println(person);
        sqlSession.close();
    }


}
