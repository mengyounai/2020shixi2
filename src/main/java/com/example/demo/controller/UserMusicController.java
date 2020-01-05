package com.example.demo.controller;

import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.exception.SellException;
import com.example.demo.service.BookService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/music")
@Slf4j
public class UserMusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private CollectionService collectionService;

    //查询音乐列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        List<MusicInfo> musicInfoPage=musicService.findUpAll();

        Page<MusicInfo> musicInfoPage1=new PageImpl<MusicInfo>(musicInfoPage);
//
        List<MusicInfo> musicInfoList=collectionService.findByuserId3(useId, PageRequest.of(page-1,size));

        Page<CollectionDTO> collectionDTOPage = collectionService.findMusicAll(useId, PageRequest.of(page-1, size));
//
        map.put("userId",useId);
        map.put("collectionDTOPage",collectionDTOPage);
        map.put("musicInfoList",musicInfoList);
        map.put("musicInfoPage",musicInfoPage1);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("music/list",map);

    }

    //查询音乐详情
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("musicId") Integer musicId,
                               Map<String,Object> map){

        MusicInfo musicInfo;
        try {
            musicInfo=musicService.findOne(musicId);
        }catch (SellException e){

            log.error("[查询音乐详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/music/list");
            return new ModelAndView("common/error",map);
        }

        map.put("musicInfo",musicInfo);
        return new ModelAndView("music/detail");
    }
}
