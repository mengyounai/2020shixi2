package com.example.demo.service;

import com.example.demo.dataobject.*;
import com.example.demo.dto.AnimeDTO;
import com.example.demo.dto.CollectionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService  {

    //发表动漫评论
    AnimeDTO create(AnimeDTO animeDTO);

    //查询所有动漫评论
    Page<Comment> findAll(Integer animeId, Pageable pageable);

    //取消评论
    Comment cancel(Integer commentId);

    //用户取消评论
    Comment cancel2(Integer userId,Integer commentId);



}
