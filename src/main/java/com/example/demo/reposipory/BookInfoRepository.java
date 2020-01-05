package com.example.demo.reposipory;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookInfoRepository extends JpaRepository<BookInfo,Integer> {

    public List<BookInfo> findByBookStatus(Integer bookStatus);

    public Page<BookInfo> findByBookStatus(Integer bookStatus, Pageable pageable);


    //根据书籍id查询书籍
    List<BookInfo> findByBookId(Integer bookId);

    //根据书籍类型查询动画
    public List<BookInfo> findByLabelType(Integer labelTypeList);

    //根据书籍出版时间查询动画
    public List<BookInfo> findByBookTime(String time);

    @Query("select p from BookInfo p where p.bookName like %:name%")
    public List<BookInfo> queryLike(@Param("name") String name);

    @Query("select p from BookInfo p where p.bookTime like %:name%")
    public List<BookInfo> queryLike2(@Param("name") String time);
}
