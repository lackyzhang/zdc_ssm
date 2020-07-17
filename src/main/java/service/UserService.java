package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public User findUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
