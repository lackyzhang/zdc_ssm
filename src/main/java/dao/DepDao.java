package dao;

import pojo.Dep;

import java.util.List;

public interface DepDao  {
   public List<Dep> findDepName();
   public Dep findByDepId(int depId);
}
