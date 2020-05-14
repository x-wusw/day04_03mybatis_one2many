package xiaowu.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xiaowu.dao.IUserDao;
import xiaowu.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = iUserDao.findAll();
        for(User user:userList){
            System.out.println(user);
            System.out.println(user.getAccounts());

        }
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
