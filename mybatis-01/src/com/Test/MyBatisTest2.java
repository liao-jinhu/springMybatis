package src.com.Test;

import src.com.po.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import src.com.po.Emp;

import java.util.List;

public class MyBatisTest2 {
    @Test
    public  void addCustomerTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("liao20");
        customer.setJobs("学生");
        customer.setPhone("12345678911");
        int rows = sqlSession.insert("com.mapper.CustomerMapper.addCustomer",customer);
        System.out.println(customer.getId());
        if(rows>0){
            System.out.println("插入成功");
        }else {
            System.out.println("执行失败");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void  findByJoy(){
        SqlSession sqlSession = MybatisUtils.getSession();
        List<Emp> Emps= sqlSession.selectList("com.mapper.EmpMapper.selectByJob","张三");
        for(src.com.po.Emp Emp:Emps){
            System.out.println(Emp.toString());
        }
        sqlSession.close();
    }





}
