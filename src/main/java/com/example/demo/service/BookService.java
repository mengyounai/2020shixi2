package com.example.demo.service;


import com.example.demo.dataobject.BookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    //根据id查询书籍
    BookInfo findOne(Integer bookId);

    //根据类型查询动漫
    List<BookInfo> findOne2(Integer labelType);

    //根据类型名字查询动漫
    List<BookInfo> findOne3(String labelName);

    //根据出版时间查询动漫
    List<BookInfo> findOne4(String time);

    //查询所有条目
    List<String> labelAll();

    //查询所有时间
    List<Integer> timeAll();

    //查询所有书籍
    Page<BookInfo> findAll(Pageable pageable);

    //查询所有在架书籍
    List<BookInfo> findUpAll();

    //查询所有在架动漫
    Page<BookInfo> findUpAll(Pageable pageable);

    //新增书籍
    BookInfo save(BookInfo bookInfo);

    //上架书籍
    BookInfo Up(Integer bookId);

    //下架动漫
    BookInfo down(Integer bookId);
}
