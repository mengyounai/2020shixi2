package com.example.demo.controller;

import com.example.demo.dataobject.BookInfo;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.exception.SellException;
import com.example.demo.service.BookService;
import com.example.demo.service.CollectionService;
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
@RequestMapping("/user/book")
@Slf4j
public class UserBookController {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private BookService bookService;

    //查询书籍列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        List<BookInfo> bookInfoPage=bookService.findUpAll();

        Page<BookInfo> bookInfoPage1=new PageImpl<BookInfo>(bookInfoPage);
//
        List<BookInfo> bookInfoList=collectionService.findByuserId2(useId,PageRequest.of(page-1,size));

        Page<CollectionDTO> collectionDTOPage = collectionService.findBookAll(useId, PageRequest.of(page-1, size));
//
        map.put("userId",useId);
        map.put("collectionDTOPage",collectionDTOPage);
        map.put("bookInfoList",bookInfoList);
        map.put("bookInfoPage",bookInfoPage1);
        map.put("page",page);
        map.put("size",size);

        return new ModelAndView("book/list",map);

    }

    //查询书籍详情
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("bookId") Integer bookId,
                               Map<String,Object> map){

        BookInfo bookInfo;
        try {
            bookInfo=bookService.findOne(bookId);
        }catch (SellException e){

            log.error("[查询动漫详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/book/list");
            return new ModelAndView("common/error",map);
        }

        map.put("bookInfo",bookInfo);
        return new ModelAndView("book/detail");
    }
}
