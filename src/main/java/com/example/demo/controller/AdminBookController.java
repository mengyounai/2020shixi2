package com.example.demo.controller;

import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Label;
import com.example.demo.exception.SellException;
import com.example.demo.form.BookForm;
import com.example.demo.service.BookService;
import com.example.demo.service.LabelService;
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
import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/book")
@Slf4j
@Api(description = "管理员管理书籍相关操作接口",produces = "application/json")
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private LabelService labelService;

    //查询书籍列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "100") Integer size,
                             @RequestParam(value = "userId" ,defaultValue = "1") Integer useId,
                             Map<String,Object> map){

        Page<BookInfo> bookInfoPage=bookService.findAll(PageRequest.of(0,100));


        map.put("bookInfoPage",bookInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("book/list2");

    }

    //下架动漫
    @GetMapping("/down")
    public ModelAndView down(@RequestParam("bookId") Integer bookId,
                             Map<String,Object> map){

        BookInfo bookInfo;
        try {
            bookInfo=bookService.down(bookId);
        }catch (SellException e){

            log.error("[下架书籍详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/book/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    //上架动漫
    @GetMapping("/up")
    public ModelAndView Up(@RequestParam("bookId") Integer bookId,
                           Map<String,Object> map){


        try {
            bookService.Up(bookId);
        }catch (SellException e){

            log.error("[上架书籍详情] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/book/list2");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "bookId",required = false) Integer bookId,
                              Map<String,Object> map){

        if (!StringUtils.isEmpty(bookId)){
            BookInfo bookInfo=bookService.findOne(bookId);
            map.put("bookInfo",bookInfo);
        }

        //查询所有的类目
        List<Label> labelList=labelService.findAll();
        map.put("labelList",labelList);

        return new ModelAndView("book/index",map);

    }
    @PostMapping("/save")
    @ApiOperation(value = "书籍新增或编辑",notes = "商品新增或编辑操作")
    public ModelAndView save(@Valid BookForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/bangumi/admin/book/index");
            return new ModelAndView("common/error");
        }

        Random random=new Random();
        Integer key= random.nextInt(1000);
        BookInfo bookInfo=new BookInfo();
        try {
            if (!StringUtils.isEmpty(form.getBookId())){
                bookInfo=bookService.findOne(form.getBookId());
            }else {
                form.setBookId(key);
            }
            BeanUtils.copyProperties(form,bookInfo);
            bookService.save(bookInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/bangumi/admin/book/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/bangumi/admin/book/list");
        return new ModelAndView("common/success",map);
    }


}


