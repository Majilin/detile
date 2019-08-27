package com.order.detile.controller;

import com.github.pagehelper.PageHelper;
import com.order.detile.domain.User;
import com.order.detile.myproperties.MyProperties;
import com.order.detile.service.UserService;
import com.order.detile.serviceimpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@Controller
public class TestController {
    /*
     * 加载属性文件的数据
     * */
    @Resource(name = "myProperties")
    MyProperties myProperties;
    /*
     * 加载userServiceImpl的数据
     * */
    @Resource(name = "userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "testa")
    public String testa() {
        //测试属性文件的数据myProperties.getPageSize()==5
        return "ssssddddoooooooooss" + myProperties.getPageSize();
    }

    /*
     * 测试依据对象id属性查询该用户的其它属性
     * */
    @ResponseBody
    @RequestMapping(value = "selectById")
    public User selectById(User user) {
        return userService.selectByPrimaryKey(user.getId());
    }


    /*
     * 测试分页、查询属性文件pageSize=5的条数、从数据库中查询5条数据
     * */
    @ResponseBody
    @RequestMapping(value = "/selectqqqqAllUser")
    public List<User> selectAllUser(int pageNum) {
        System.out.println(pageNum + "\t" + "wwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        PageHelper.startPage(pageNum, myProperties.getPageSize());
        List<User> userList = userService.selectAllUser();
        return userList;
    }

    /*
     * 测试  jsp
     *
     * */
    @RequestMapping(value = "tsetjsp")
    public String tsetjsp() {

        return "a";
    }

    /*
     * 测试文件上传
     *
     * */
    @ResponseBody
    @RequestMapping(value = "/upload")
    public String upload1(@RequestParam("file") MultipartFile file) {
        File f = new File("M:\\project\\detile\\src\\main\\webapp\\templates\\" + file.getOriginalFilename());
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/templates/" + file.getOriginalFilename();
    }
/*
*  测试文件下载
*
* */
    @RequestMapping("/downloadfile")
    public void hello(HttpServletResponse resp) {
        String path = "违纪.png";//要下载的文件名字
        resp.setContentType("application/x-tar;charset=utf-8");
        try {
            //保存下载的路径
            FileOutputStream f = new FileOutputStream("M:\\project\\detile\\src\\main\\webapp\\templates\\" + path);
            resp.setHeader("Content-disposition", "attachment;filename="
                    + java.net.URLEncoder.encode(path, "UTF-8"));
            //文件的路径+文件名字  C:\\Users\\马计林\\Pictures\\pic\\  + path
            FileCopyUtils.copy(new FileInputStream("C:\\Users\\马计林\\Pictures\\pic\\" + path), f);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
