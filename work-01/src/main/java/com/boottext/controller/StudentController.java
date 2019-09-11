package com.boottext.controller;

import com.boottext.entity.Student;
import com.boottext.mapper.StudentDao;
import com.boottext.service.StudentDaoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/show")
public class StudentController {

    @Autowired
    private StudentDaoService service;

    /**
     * 登录
     */
    @RequestMapping("/loginUser")
    public String loginUser(Student s) {
        return "Login";
    }

    /**
     * 进入添加页
     */
    @RequestMapping("/gotoadd")
    public ModelAndView addgo() {
        System.out.println("gotoadd方法");
        return new ModelAndView("insertStudent");
    }

    /**
     * 显示所有
     *
     * @param model
     */
    @RequestMapping("/list")
    public String findall(Model model) {
        List<Student> findall = service.findall();
        model.addAttribute("msg", findall);
        return "ShowStudent";
    }

    /**
     * 添加学生之后跳转回主页
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/add")
    public String addStu(Student s) {
        service.addUser(s);
        return "redirect:/show/list";
    }

    /**
     * 查询到要修改的ID中的一条数据
     */
    @GetMapping("/update/{id}")
    public ModelAndView UpdUser(Student s, @PathVariable("id") int id) {
        Student byid = service.findByid(id);
        System.out.println(byid);
        //这一条id的数据都装在msg里面了  网页中使用对应代码获取具体值
        //修改页面
        return new ModelAndView("updateStudent", "msg", byid);
    }

    /**
     * 修改方法
     *
     * @param s
     * @return
     */
    @PostMapping("/update")
    public String update(Student s, Model model) {
        if (s == null) {
            return "Fail";
        } else {
            Integer i = service.updateUser(s);
            if (service.updateUser(s) == 1) {
                return "redirect:/show/list";
            } else {
                return "Fail";
            }
        }
    }

    /**
     * modelandview示例
     */
    public ModelAndView test(Model model) {
        model.addAttribute("msg", "msg的信息");
        return new ModelAndView("Fail", "modelTest", model);
    }

    /**
     * id删除
     */
    @GetMapping("/delete/{id}")
    public String deleStu(@PathVariable("id") Integer id) {
        service.deleteUser(id);
        return "redirect:/show/list";
    }


    /**
     * 输入账号密码
     */
    @PostMapping("/login")
    public String login(Student s, Model model) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if ("".equals(s.getUsername()) && "".equals(s.getPassword())) {
            model.addAttribute("msg", "用户名密码 不能为空");
            return "Login";
        } else {
            try {
                //有token 了 用户名密码都存了进去
                UsernamePasswordToken token = new UsernamePasswordToken(s.getUsername(), s.getPassword());
                //欢迎登录  前台显示用户名
                session.setAttribute("msg", s.getUsername());
                subject.login(token);
            } catch (IncorrectCredentialsException e) {
                model.addAttribute("msg", "密码错误");
                return "Login";
            } catch (UnknownAccountException e) {
                model.addAttribute("msg", "用户名错误");
                return "Login";
            }
        }
        return "redirect:/show/list";
    }

    /**
     * 登出
     */
    @RequestMapping("/logout")
    public ModelAndView logout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg", "退出成功");
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }

    /**
     * 没有权限
     */
    @RequestMapping("/unAuth")
    public String unAuth() {
        return "noAuth";
    }
}
