package bo;

import pojo.Dep;
import pojo.User;

import java.util.List;

public class Dep_bo {
    private List<Dep> depList;
    private User user;

    public List<Dep> getDepList() {
        return depList;
    }

    public void setDepList(List<Dep> depList) {
        this.depList = depList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
