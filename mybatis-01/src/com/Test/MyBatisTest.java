package src.com.Test;

import src.com.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findCustomerById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer =sqlSession.selectOne("com.mapper.CustomerMapper.findCustomerByID",1);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @Test
    public void findCustomerByName() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<src.com.po.Customer> customers = sqlSession.selectList("com.mapper.CustomerMapper.findCustomerByName","j");
        for(src.com.po.Customer customer:customers){
            System.out.println(customer.toString());
        }
        sqlSession.close();
    }

    @Test
    public void addCustomer() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = new Customer();
        customer.setUsername("廖进湖11");
        customer.setJobs("学生");
        customer.setPhone("13824699637");
        int rows = sqlSession.insert("com.mapper.CustomerMapper.addCustomer",customer);
        if(rows>0){
            System.out.println("插入成功");
        }else {
            System.out.println("执行失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateCustomer() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("廖进湖");
        customer.setJobs("学生");
        customer.setPhone("13824699637");
        int rows = sqlSession.insert("com.mapper.CustomerMapper.updateCustomer",customer);
        if(rows>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void deleteCustomer() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.insert("com.mapper.CustomerMapper.deleteCustomer",6);
        if(rows>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }




}
