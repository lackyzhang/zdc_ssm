package service;

import dao.DepDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Dep;

import java.util.List;

@Service
public class DepService {
    @Autowired
    private DepDao depDao;
    public List<Dep> findAll(){
        List<Dep> depList = depDao.findDepName();
        return depList;

    }
}
