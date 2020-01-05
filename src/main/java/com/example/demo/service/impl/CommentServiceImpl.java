package com.example.demo.service.impl;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Comment;
import com.example.demo.dto.AnimeDTO;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.CommentRepository;
import com.example.demo.service.CommentService;
import com.example.demo.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AnimeInfoRepository animeInfoRepository;


    @Override
    public AnimeDTO create(AnimeDTO animeDTO) {


        Random random=new Random();
        Integer key= random.nextInt(100);
        Comment comment=new Comment();
        comment.setCommentId(10);
        BeanUtils.copyProperties(animeDTO,comment);

        commentRepository.save(comment);

        return animeDTO;
    }

    @Override
    public Page<Comment> findAll(Integer animeId, Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findByAnimeId(animeId, pageable);

        return commentPage;
    }

    @Override
    public Comment cancel(Integer commentId) {

        Comment byAnimeId = commentRepository.findById(commentId).orElse(null);
        if (byAnimeId==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        byAnimeId.setCommentStatus(1);
        Comment comment=commentRepository.save(byAnimeId);

        return comment;
    }

    @Override
    public Comment cancel2(Integer userId, Integer commentId) {

//        Comment byAnimeIdAndUserId = commentRepository.findByAnimeIdAndUserId(commentId, userId);
//        if (byAnimeIdAndUserId==null){
//            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//        }
//        byAnimeIdAndUserId
        return null;
    }


}
