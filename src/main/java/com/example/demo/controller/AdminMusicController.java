package com.example.demo.controller;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Label;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.exception.SellException;
import com.example.demo.form.AnimeForm;
import com.example.demo.form.MusicForm;
import com.example.demo.service.LabelService;
import com.example.demo.service.MusicService;
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
@RequestMapping("/admin/music")
@Slf4j
@Api(description = "管理员管理音乐相关操作接口",produces = "application/json")
public class AdminMusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private LabelService labelService;

    //查询音乐列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "100") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        Page<MusicInfo> musicInfoPage=musicService.findAll(PageRequest.of(0,100));


        map.put("musicInfoPage",musicInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("music/list2");

    }

    //下架音乐
    @GetMapping("/down")
    public ModelAndView down(@RequestParam("musicId") Integer musicId,
                             Map<String,Object> map){

        MusicInfo musicInfo;
        try {
            musicInfo=musicService.down(musicId);
        }catch (SellException e){

            log.error("[下架动漫详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/music/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    //上架音乐
    @GetMapping("/up")
    public ModelAndView Up(@RequestParam("musicId") Integer musicId,
                           Map<String,Object> map){


        try {
            musicService.Up(musicId);
        }catch (SellException e){

            log.error("[上架动漫详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/music/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "musicId",required = false) Integer musicId,
                              Map<String,Object> map){

        if (!StringUtils.isEmpty(musicId)){
            MusicInfo musicInfo=musicService.findOne(musicId);
            map.put("musicInfo",musicInfo);
        }

        //查询所有的类目
        List<Label> labelList=labelService.findAll();
        map.put("labelList",labelList);

        return new ModelAndView("music/index",map);

    }
    @PostMapping("/save")
    @ApiOperation(value = "音乐新增或编辑",notes = "商品新增或编辑操作")
    public ModelAndView save(@Valid MusicForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/bangumi/admin/music/index");
            return new ModelAndView("common/error");
        }

        Random random=new Random();
        Integer key= random.nextInt(1000);
        MusicInfo musicInfo=new MusicInfo();
        try {
            if (!StringUtils.isEmpty(form.getMusicId())){
                musicInfo=musicService.findOne(form.getMusicId());
            }else {
                form.setMusicId(key);
            }
            BeanUtils.copyProperties(form,musicInfo);
            musicService.save(musicInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/music/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/bangumi/admin/music/list");
        return new ModelAndView("common/success",map);
    }


}
