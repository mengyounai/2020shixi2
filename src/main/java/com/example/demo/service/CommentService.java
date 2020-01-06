package com.example.demo.service;

import com.example.demo.VO.CommentVO;
import com.example.demo.dataobject.*;
import com.example.demo.dto.AnimeDTO;
import com.example.demo.dto.CollectionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService  {

    //查询所有上架评论
    List<Comment> commentupAll();

    //动漫

    //发表动漫评论
    AnimeDTO create(AnimeDTO animeDTO);

    //发表动漫评论真
    Comment animecreate(Integer userId,Integer animeId,String comment);

    //查询单个动漫所有评论
    List<Comment> animeAll(Integer animeId);

    //查询单个动漫所有评论
    List<CommentVO>  animeAll2(Integer animeId);



    //书籍

    //发表动漫评论真
    Comment bookcreate(Integer userId,Integer bookId,String comment);

    //查询单个动漫所有评论
    List<Comment> bookAll(Integer bookId);

    //查询单个动漫所有评论
    List<CommentVO>  bookAll2(Integer bookId);


    //音乐

    //发表音乐评论真
    Comment musiccreate(Integer userId,Integer musicId,String comment);

    //查询单个音乐所有评论
    List<Comment> musicAll(Integer musicId);

    //查询单个音乐所有评论
    List<CommentVO>  musicAll2(Integer musicId);



    //查询所有动漫评论
    Page<Comment> findAll(Integer animeId, Pageable pageable);

    //取消评论
    Comment cancel(Integer commentId);

    //用户取消评论
    Comment cancel2(Integer userId,Integer commentId);





}
