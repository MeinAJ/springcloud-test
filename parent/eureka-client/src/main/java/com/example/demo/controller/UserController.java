package com.example.demo.controller;


import com.example.demo.model.MUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings(value = "static-access")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{


    @RequestMapping(value = "/login", headers = "Accept=*/*", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(HttpServletRequest request,
                        @RequestBody String mUserInfo){
        MUser mUser = json.parseObject(mUserInfo, MUser.class);
        try {

        } catch (Exception e){
            e.printStackTrace();
        }
        return json.toJSONString(mUser);
    }
}
