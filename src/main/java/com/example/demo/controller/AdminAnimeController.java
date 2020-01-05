package com.example.demo.controller;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Label;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.exception.SellException;
import com.example.demo.form.AnimeForm;
import com.example.demo.service.AnimeService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.LabelService;
import com.example.demo.util.KeyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/anime")
@Slf4j
@Api(description = "管理员管理动漫相关操作接口",produces = "application/json")
public class AdminAnimeController {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private AnimeService animeService;

    @Autowired
    private LabelService labelService;


    //查询动漫列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "100") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        Page<AnimeInfo> animeInfoPage=animeService.findAll(PageRequest.of(0,100));


        map.put("animeInfoPage",animeInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("anime/list2");

    }

    //下架动漫
    @GetMapping("/down")
    public ModelAndView down(@RequestParam("animeId") Integer animeId,
                               Map<String,Object> map){

        AnimeInfo animeInfo;
        try {
            animeInfo=animeService.down(animeId);
        }catch (SellException e){

            log.error("[下架动漫详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/anime/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    //上架动漫
    @GetMapping("/up")
    public ModelAndView Up(@RequestParam("animeId") Integer animeId,
                               Map<String,Object> map){


        try {
            animeService.Up(animeId);
        }catch (SellException e){

            log.error("[上架动漫详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/anime/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "animeId",required = false) Integer animeId,
                              Map<String,Object> map){

        if (!StringUtils.isEmpty(animeId)){
            AnimeInfo animeInfo=animeService.findOne(animeId);
            map.put("animeInfo",animeInfo);
        }

        //查询所有的类目
        List<Label> labelList=labelService.findAll();
        map.put("labelList",labelList);

        return new ModelAndView("anime/index",map);

    }
    @PostMapping("/save")
    @ApiOperation(value = "动漫新增或编辑",notes = "商品新增或编辑操作")
    public ModelAndView save(@Valid AnimeForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/bangumi/admin/anime/index");
            return new ModelAndView("common/error");
        }

        Random random=new Random();
        Integer key= random.nextInt(100);
        AnimeInfo animeInfo=new AnimeInfo();
        try {
            if (!StringUtils.isEmpty(form.getAnimeId())){
                animeInfo=animeService.findOne(form.getAnimeId());
            }else {
                form.setAnimeId(key);
            }
            BeanUtils.copyProperties(form,animeInfo);
            animeService.save(animeInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/anime/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/bangumi/admin/anime/list");
        return new ModelAndView("common/success",map);
    }


}
