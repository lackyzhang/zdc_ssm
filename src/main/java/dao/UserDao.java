package dao;

import pojo.User;

public interface UserDao {
    public User findByUserName(String userName);
}
