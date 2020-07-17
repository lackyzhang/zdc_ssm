import dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class test1 {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        User user=userDao.findByUserName("admin");
        System.out.println(user.getPassword());
    }
}
