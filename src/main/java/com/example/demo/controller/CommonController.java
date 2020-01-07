//package com.example.demo.controller;
//
//import com.example.demo.dataobject.*;
//import com.example.demo.dto.CollectionDTO;
//import com.example.demo.enums.ResultEnum;
//import com.example.demo.exception.SellException;
//import com.example.demo.form.AnimeForm;
//import com.example.demo.form.UserForm;
//import com.example.demo.service.AnimeService;
//import com.example.demo.service.BookService;
//import com.example.demo.service.MusicService;
//import com.example.demo.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//@RestController
//@RequestMapping("/user/common")
//@Slf4j
//public class CommonController {
//
//    @Autowired
//    private AnimeService animeService;
//
//    @Autowired
//    private BookService bookService;
//
//    @Autowired
//    private MusicService musicService;
//
//    @Autowired
//    private UserService userService;
//
//    //查询标签列表
//    @GetMapping("/index")
//    public ModelAndView list(Map<String, Object> map) {
//
//        Page<AnimeInfo> animeInfoList = animeService.findUpAll(PageRequest.of(0, 5));
//
//        Page<BookInfo> bookInfoList = bookService.findUpAll(PageRequest.of(0, 5));
//
//        Page<MusicInfo> musicInfoList = musicService.findUpAll(PageRequest.of(0, 5));
//
//        map.put("animeInfoList", animeInfoList);
//        map.put("bookInfoList", bookInfoList);
//        map.put("musicInfoList", musicInfoList);
//
//        return new ModelAndView("common/index", map);
//
//    }
//
//    @PostMapping("/login")
//    public ModelAndView login(@Valid UserForm form,
//                              BindingResult bindingResult,
//                              Map<String, Object> map) {
//        if (bindingResult.hasErrors()) {
//            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
//            map.put("url", "/bangumi/user/common/index2");
//            return new ModelAndView("common/error");
//        }
//
//        UserInfo userInfo;
//        try {
//            userInfo = userService.findone(form.getUserEmail(), form.getUserPassword());
//        } catch (SellException e) {
//            map.put("msg", e.getMessage());
//            map.put("url", "/bangumi/user/common/index2");
//            return new ModelAndView("common/error", map);
//        }
//        if (userInfo!=null){
//            map.put("url", "/bangumi/user/common/index");
//        }else {
//            map.put("msg", ResultEnum.Login_FAIL.getMessage());
//            map.put("url", "/bangumi/user/common/index2");
//            return new ModelAndView("common/error");
//        }
//        return new ModelAndView("common/success", map);
//    }
//
//    @GetMapping("/index2")
//    public ModelAndView login(Map<String, Object> map) {
//
//
//        return new ModelAndView("common/login");
//    }
//}