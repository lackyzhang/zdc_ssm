package dao;

import pojo.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> findEmpByDepId(int depId);
}
