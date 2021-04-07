package src.com.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import src.com.po.Emp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmpTest {

    @Test
    public  void fid() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<src.com.po.Emp> Emps= sqlSession.selectList("com.mapper.EmpMapper.selectByJob","张三");
        for(src.com.po.Emp Emp:Emps){
            System.out.println(Emp.toString());
        }
        sqlSession.close();
    }

    @Test
    public  void delete() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows=sqlSession.update("com.mapper.EmpMapper.deleteByJob","张三");
        if(rows>0){
            System.out.println("删除成功"+rows);
        }else {
            System.out.println("删除失败");
        }
       sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addEmp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setEmpno(1001);
        emp.setEname("廖进湖");
        emp.setJob("java工程师");
        emp.setMgr(10000);
        emp.setHiredate("2021-4-3");
        emp.setSal(3000);
        emp.setComm(900);
        emp.setDeptno(20);
        int rows=sqlSession.insert("com.mapper.EmpMapper.addEmp",emp);
        if(rows>0){
            System.out.println("数据插入成功");
        }else {
            System.out.println("数据插入失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEmp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("src/mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setEmpno(1001);
        emp.setEname("廖进湖123");
        emp.setJob("java工程师");
        emp.setMgr(10000);
        emp.setHiredate("2021-4-3");
        emp.setSal(3000);
        emp.setComm(900);
        emp.setDeptno(20);
        int rows=sqlSession.update("com.mapper.EmpMapper.updateEmp",emp);
        if(rows>0){
            System.out.println("数据更新成功");
        }else {
            System.out.println("数据更新失败");
        }
        sqlSession.commit();
        sqlSession.close();


    }




}


