package com.example.demo.controller;


import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.exception.SellException;
import com.example.demo.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/people")
@Slf4j
public class UserPeopleController {

    @Autowired
    private PeopleService peopleService;

    //查询人物列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        Page<PeopleInfo> peopleInfoPage=peopleService.findAll(PageRequest.of(page,size));

        Page<PeopleInfo> peopleInfoPage2=peopleService.findAll(PageRequest.of(page+1,size));

        map.put("peopleInfoPage",peopleInfoPage);
        map.put("peopleInfoPage2",peopleInfoPage2);

        return new ModelAndView("people/list",map);

    }

    //查询人物详情
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("peopleId") Integer peopleId,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "5") Integer size,
                               Map<String,Object> map){

        PeopleInfo peopleInfo;
        try {
            peopleInfo=peopleService.findOne(peopleId);
        }catch (SellException e){

            log.error("[查询人物详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/people/list");
            return new ModelAndView("common/error",map);
        }

        map.put("peopleInfo",peopleInfo);

        return new ModelAndView("people/detail");
    }
}
