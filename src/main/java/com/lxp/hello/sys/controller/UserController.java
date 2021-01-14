package com.lxp.hello.sys.controller;

import com.lxp.hello.sys.bean.UserBean;
import com.lxp.hello.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    @Autowired
    public static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String findUserByUserNameAndPassword(Model model, UserBean userBean){
        if(userBean!=null && userBean.getUserName() !=null && userBean.getPassword() !=null){
            UserBean userBean1 = userService.findUserByUserNameAndPassword(userBean);
            if(userBean1.getId()!=null){
                model.addAttribute("flag","success");
                model.addAttribute("msg","登录成功");
                model.addAttribute("user",userBean1);
                return "index";
            }else{
                model.addAttribute("flag","false");
                model.addAttribute("msg","用户名或密码错误");
                return "login";
            }
        }else{
            model.addAttribute("flag","false");
            model.addAttribute("msg","用户名或密码非法");
            return "login";
        }
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/registPage")
    public String registPage(){
        return "registPage";
    }

    @RequestMapping("/regist")
    public String regist(Model model,UserBean userBean){
        if(userBean!=null&&userBean.getUserName()!=null&&userBean.getPassword()!=null&&userBean.getRePassword()!=null){
            if(userBean.getPassword().equals(userBean.getRePassword())){
                UserBean userBean1 = userService.findUserByUserName(userBean);
                if(userBean1!=null){
                    model.addAttribute("flag",false);
                    model.addAttribute("msg","用户名已存在");
                    return "registPage";
                }else {
                    userService.saveUser(userBean);
                    model.addAttribute("flag",true);
                    model.addAttribute("msg","注册成功");
                    return "login";
                }
            }else{
                model.addAttribute("flag",false);
                model.addAttribute("msg","两次密码不一致");
                return "registPage";
            }
        }else{
            model.addAttribute("flag","false");
            model.addAttribute("msg","信息不全");
            return "registPage";
        }
    }
}
