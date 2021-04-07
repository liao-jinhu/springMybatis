package src.com.Test;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import src.com.po.Emp;
import java.io.IOException;
import java.util.List;
public class MyBatisTest {

    //查询跟李四相同职位的所有员工信息 测试
    @Test
    public void  findByJoy(){
        SqlSession sqlSession = MybatisUtils.getSession();
        List<Emp> Emps= sqlSession.selectList
                ("com.mapper.EmpMapper.selectByJob","张三");
        for(Emp Emp:Emps){
            System.out.println(Emp.toString());
        }
        sqlSession.close();
    }

    //删除跟陈二相同职位的所有员工信息 测试
    @Test
    public  void deleteTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        int rows=sqlSession.update("com.mapper.EmpMapper.deleteByJob","张三");
        if(rows>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //添加员工记录 测试
    @Test
    public void addEmpTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        Emp emp = new Emp();
        emp.setEmpno(1000);
        emp.setEname("廖进湖");
        emp.setJob("java工程师");
        emp.setMgr(10000);
        emp.setHiredate("2021-4-3");
        emp.setSal(3000);
        emp.setComm(900);
        emp.setDeptno(20);
        int rows=sqlSession.insert
                ("com.mapper.EmpMapper.addEmp",emp);
        if(rows>0){
            System.out.println("数据插入成功");
        }else {
            System.out.println("数据插入失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    //修改员工姓名的职位 测试
    @Test
    public void updateEmpTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        Emp emp = new Emp();
        emp.setEmpno(1000);
        emp.setJob("系统架构师");
        int rows=sqlSession.update
                ("com.mapper.EmpMapper.updateEmp",emp);
        if(rows>0){
            System.out.println("更改职位成功");
        }else {
            System.out.println("更改职位失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
