package com.wzy.controller;

import com.google.gson.Gson;
import com.wzy.page.Page;
import com.wzy.pojo.AttributePo;
import com.wzy.pojo.RoomSetPo;
import com.wzy.pojo.UserPo;
import com.wzy.pojo.Users;
import com.wzy.service.UserService;
import com.wzy.service.UserServieAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户
 *
 * @Auther: wzy
 * @Date: 2021/03/25/9:00
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserServieAuto userServiceAuto;
    @Autowired
    private UserService userService;

    @RequestMapping("/tolist")
    public ModelAndView tolist(HttpServletRequest request, Integer currentPage, String userName) {
        ModelAndView mv = null;
        mv = new ModelAndView("/users/list");
        Page<Users> vo = new Page<Users>();
        if (currentPage == null) {
            currentPage = 1;
        } else if (currentPage == 0) {
            currentPage = 1;
        }
        if (userName == null) {
            userName = "";
        }
        vo.setCurrentPage(currentPage);
        vo = userServiceAuto.pageFuzzyselect(userName, vo);
        mv.addObject("list", vo);
        mv.addObject("userName", userName);
        return mv;
    }

    /**
     * 普通
     * @param request
     * @param currentPage
     * @param userName
     * @return
     */
    @RequestMapping("/toListUser")
    public ModelAndView tolist_normal(HttpServletRequest request, Integer currentPage, String userName) {
        ModelAndView mv = null;
        mv = new ModelAndView("/users/list_user");
        Page<Users> vo = new Page<Users>();
        if (currentPage == null) {
            currentPage = 1;
        } else if (currentPage == 0) {
            currentPage = 1;
        }
        if (userName == null) {
            userName = "";
        }
        vo.setCurrentPage(currentPage);
        vo = userServiceAuto.pageFuzzyselect(userName, vo);
        mv.addObject("list", vo);
        mv.addObject("userName", userName);
        return mv;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd() {
        ModelAndView mv = null;
        mv = new ModelAndView("/users/add");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(Users user) {
        ModelAndView mv = null;
        userServiceAuto.insertUsers(user);
        mv = new ModelAndView("redirect:/users/tolist.do");
        return mv;
    }

    @RequestMapping("/toupdate")
    public ModelAndView toupdate(String id) {
        ModelAndView mv = null;
        mv = new ModelAndView("/users/update");
        Users user = userServiceAuto.selectUserById(Integer.parseInt(id));
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(Users user) {
        ModelAndView mv = null;
        userServiceAuto.updateByUserName(user);
        mv = new ModelAndView("redirect:/users/tolist.do");
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String ids) {
        ModelAndView mv = null;
        String[] FenGe = ids.split(",");
        for (int i = 0; i < FenGe.length; i++) {
            userServiceAuto.deleteByUserId(Integer.parseInt(FenGe[i]));
        }
        mv = new ModelAndView("redirect:/users/tolist.do");
        return mv;
    }

    @RequestMapping("/findIdByuserName")
    public int findIdByuserName(String userName,String userId) {
        UserPo user = userService.findIdByuserName(userName);
        Users users = userServiceAuto.selectUserById(Integer.parseInt(userId));
        if(user.getUserName().equals(users.getUsername())){
            return 1;
        }
       return 0;
    }


    @ResponseBody
    @RequestMapping(value = "/YZ")
    public Object YZ(String userName) {
        int YorN = userServiceAuto.selectIsExit(userName);
        Gson gson = new Gson();
        return gson.toJson(YorN);
    }
}
