//package com.example.demo.controller;
//
//import com.example.demo.dataobject.AnimeInfo;
//import com.example.demo.dataobject.Collection;
//import com.example.demo.dataobject.Comment;
//import com.example.demo.dataobject.Label;
//import com.example.demo.dto.CollectionDTO;
//import com.example.demo.exception.SellException;
//import com.example.demo.service.AnimeService;
//import com.example.demo.service.CollectionService;
//import com.example.demo.service.CommentService;
//import com.example.demo.service.LabelService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/user/anime")
//@Slf4j
//public class UserAnimeController2 {
//
//    @Autowired
//    private CollectionService collectionService;
//
//    @Autowired
//    private AnimeService animeService;
//
//    @Autowired
//    private LabelService labelService;
//
//    @Autowired
//    private CommentService commentService;
//
//
//    //查询动漫列表
//    @GetMapping("/list")
//    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                             @RequestParam(value = "size", defaultValue = "5") Integer size,
//                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
//                             Map<String,Object> map){
//
//        List<AnimeInfo> animeInfoPage=animeService.findUpAll();
////
//        Page<AnimeInfo> animeInfoPage1=new PageImpl<>(animeInfoPage);
//
//        List<AnimeInfo> animeInfoList=collectionService.findByuserId(useId,PageRequest.of(page-1,size));
//
//        Page<CollectionDTO> collectionDTOPage = collectionService.findAnimeAll(useId, PageRequest.of(page-1, size));
//
//        List<Label> labelList=labelService.labelList();
//
//        map.put("labelList",labelList);
//        map.put("userId",useId);
//        map.put("collectionDTOPage",collectionDTOPage);
//        map.put("animeInfoList",animeInfoList);
//        map.put("animeInfoPage",animeInfoPage1);
//        map.put("currentPage",page);
//        map.put("size",size);
//
//
//        return new ModelAndView("anime/list",map);
//
//    }
//
//    //查询动漫详情
//    @GetMapping("/detail")
//    public ModelAndView detail(@RequestParam("animeId") Integer animeId,
//                               @RequestParam(value = "page", defaultValue = "0") Integer page,
//                               @RequestParam(value = "size", defaultValue = "5") Integer size,
//                               Map<String,Object> map){
//
//        Page<Comment> commentPage=commentService.findAll(animeId,PageRequest.of(page,size));
//
//
//        AnimeInfo animeInfo;
//        try {
//            animeInfo=animeService.findOne(animeId);
//        }catch (SellException e){
//
//            log.error("[查询动漫详情] 发生异常,result={}",e);
//
//            map.put("msg",e.getMessage());
//            map.put("url","/bangumi/user/anime/list");
//            return new ModelAndView("common/error",map);
//        }
//
//        map.put("animeinfo",animeInfo);
//        map.put("commentPage",commentPage);
//
//        return new ModelAndView("anime/detail");
//    }
//
////    //下架动漫
////    @GetMapping("cancel")
////    public ModelAndView cancel(@RequestParam("animeId") Integer animeId,
////                               Map<String,Object> map){
////
////
////        return null;
////    }
//
////    //上架动漫
////    @GetMapping("list")
////    public ModelAndView list(){
////        return null;
////    }
//}
