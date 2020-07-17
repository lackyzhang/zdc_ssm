package handler;

import bo.Dep_bo;
import dto.TransferObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dep;
import pojo.User;
import service.DepService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private DepService depService;
    @GetMapping("login")
    public TransferObj login(String userName, String password, HttpServletRequest request){
        TransferObj transferObj = new TransferObj();
        System.out.println("login");
        System.out.println(userService);
        User user=userService.findUserByUserName(userName);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.setAttribute("loginUser", user);
                System.out.println(user.getUserName());
                transferObj.setMessage("success");
            } else {
                transferObj.setCode(1);
                transferObj.setMessage("密码错误");
            }
        } else {
            transferObj.setCode(1);
            transferObj.setMessage("用户名不存在");
        }
        return transferObj;
    }
    @GetMapping("depinfo")
    public Dep_bo depinfo(HttpServletRequest request) {
        List<Dep> depList=new ArrayList<>();
        User user= (User) request.getAttribute("loginUser");
        Dep_bo dep_bo = new Dep_bo();
        depList=depService.findAll();
        dep_bo.setDepList(depList);
        dep_bo.setUser(user);

        return dep_bo;
    }
}
