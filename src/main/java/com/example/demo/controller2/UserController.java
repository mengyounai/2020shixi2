package com.example.demo.controller2;

import com.example.demo.VO.UserVO;
import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.dataobject.UserInfo;
import com.example.demo.reposipory.UserInfoRespository;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(description = "用户信息相关操作接口")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoRespository userInfoRespository;

    @RequestMapping("/getuser")
    @ResponseBody
    public UserVO finone(@RequestBody Map<String, Object> info){

        String userId=info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        UserVO userVO=new UserVO();

        userVO=userService.findone(userId2);

        return userVO;

    }

    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(@RequestBody Map<String, Object> info){

        String userId=info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String name= info.get("name").toString();

        String sex= info.get("sex").toString();
        Integer sex2=Integer.parseInt(sex);

        String birth= info.get("birth").toString();

        String birth2=birth.substring(0,10);
        String qianming= info.get("qianming").toString();

        String des= info.get("des").toString();

        userService.save(userId2,name,sex2,birth2,qianming,des);

        return true;

    }

    @RequestMapping("/uppass")
    @ResponseBody
    public Boolean uppass(@RequestBody Map<String, Object> info){

        String userId=info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String email= info.get("email").toString();

        String password1= info.get("password1").toString();

        String password2= info.get("password2").toString();

        Boolean a=userService.password(userId2,email,password1,password2);

        return a;

    }

    @RequestMapping("/register")
    @ResponseBody
    public Boolean register(@RequestBody Map<String, Object> info){

        String email= info.get("email").toString();

        String username= info.get("username").toString();

        String password1= info.get("password1").toString();

        List<UserInfo> userInfoList=userInfoRespository.findAll();

        boolean a=true;
        for (UserInfo userInfo:userInfoList){
            if (userInfo.getUserName()==username){
                a=false;
                break;
            }else {
                userService.register(username,email,password1);
                a=true;
            }
        }


        return a;

    }
}
