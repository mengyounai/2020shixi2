package com.example.demo.service.impl;

import com.example.demo.VO.CommentVO;
import com.example.demo.dataobject.Comment;
import com.example.demo.dto.AnimeDTO;
import com.example.demo.reposipory.CommentRepository;
import com.example.demo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository repository;

    @Test
    public void create() {

        AnimeDTO animeDTO=new AnimeDTO();
        animeDTO.setAnimeId(10);

        Comment comment=new Comment();
        comment.setCommentId("12");
        comment.setUserId(1);
        comment.setCommentDescription("我永远喜欢我妻由乃");
        comment.setCommentStatus(0);

        animeDTO.setComment(comment);

        AnimeDTO result=commentService.create(animeDTO);
        log.info("[创建评论] result="+result);
        assertNotNull(result);

    }

    @Test
    public void findAll() {
    }

    @Test
    public void cancel() {
        Comment comment=commentService.cancel(1);
        log.info("[撤回评论] comment="+comment);
        assertNotNull(comment);
    }

    @Test
    public void discussAll() {
        List<CommentVO> commentVOList=commentService.animeAll2(1);
        log.info("[撤回评论] comment="+commentVOList);
        assertNotNull(commentVOList);
    }

    @Test
    public void animecreate() {
        Comment comment=commentService.animecreate(2,1,"童年回忆");
        log.info("[评论] comment="+comment);
        assertNotNull(comment);
    }

//    @Test
//    public void save(){
//        Comment comment=new Comment();
//        comment.setCommentId(10);
//        comment.setUserId(1);
//        comment.setCommentDescription("我永远喜欢我妻我乃");
//        comment.setAnimeId(11);
//        comment.setCommentStatus(0);
//
//        Comment result=repository.save(comment);
//
//        log.info("[保存信息为] result="+result);
//        assertNotNull(result);
//    }
}