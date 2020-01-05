package com.example.demo.controller;

import com.example.demo.dataobject.Label;
import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.exception.SellException;
import com.example.demo.form.PeopleForm;
import com.example.demo.reposipory.PeopleInfoRespository;
import com.example.demo.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/people")
@Slf4j
@Api(description = "管理员管理人物相关操作接口",produces = "application/json")
public class AdminPeopleController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PeopleInfoRespository respository;

    //查询动漫列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "100") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        Page<PeopleInfo> peopleInfoPage=peopleService.findAll(PageRequest.of(0,100));


        map.put("peopleInfoPage",peopleInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("people/list2");

    }


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "peopleId",required = false) Integer peopleId,
                              Map<String,Object> map){

        if (!StringUtils.isEmpty(peopleId)){
            PeopleInfo peopleInfo=peopleService.findOne(peopleId);
            map.put("peopleInfo",peopleInfo);
        }



        return new ModelAndView("people/index",map);

    }
    @PostMapping("/save")
    @ApiOperation(value = "人物新增或编辑",notes = "商品新增或编辑操作")
    public ModelAndView save(@Valid PeopleForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/bangumi/admin/people/index");
            return new ModelAndView("common/error");
        }

        Random random=new Random();
        Integer key= random.nextInt(100);
        PeopleInfo peopleInfo=new PeopleInfo();
        try {
            if (!StringUtils.isEmpty(form.getPeopleId())){
                peopleInfo=peopleService.findOne(form.getPeopleId());
            }else {
                form.setPeopleId(key);
            }
            BeanUtils.copyProperties(form,peopleInfo);
            respository.save(peopleInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/people/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/bangumi/admin/people/list");
        return new ModelAndView("common/success",map);
    }


}
