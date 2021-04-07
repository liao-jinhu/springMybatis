package src.com.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils2 {
    private  static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            //加载配置文件
            Reader reader = Resources.getResourceAsReader("src/mybatis-config2.xml");
            //构建sqlSessionFactory工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static SqlSession getSession(){
        return  sqlSessionFactory.openSession();
    }
}
