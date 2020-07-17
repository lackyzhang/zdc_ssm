package service;

import dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Emp;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;
    public List<Emp> findEmpByDepId(int depId){
        List<Emp> emplist = empDao.findEmpByDepId(depId);
        return emplist;
    }
}
