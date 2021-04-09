package src.com.Test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import src.com.po.Orders;
import src.com.po.User;


public class MybatisUserTest {
    @Test
    public void findUserTest(){
        SqlSession session = MybatisUtils2.getSession();
        User user = session.selectOne("com.mapper.UserMapper.findUserWithOrders",1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void findOrdersTest(){
        SqlSession session = MybatisUtils2.getSession();
        Orders order = session.selectOne("com.mapper.OrderMapper.findOrdersWithProduct",1);
        System.out.println(order);
        session.close();
    }


}

