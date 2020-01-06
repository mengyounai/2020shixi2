package com.example.demo.reposipory;

import com.example.demo.dataobject.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void save(){
        Comment comment=new Comment();
        comment.setCommentId("10");
        comment.setUserId(1);
        comment.setCommentDescription("我永远喜欢我妻我乃");
        comment.setAnimeId(11);
        comment.setCommentStatus(0);

        Comment result=repository.save(comment);

        log.info("[保存信息为] result="+result);
        assertNotNull(result);
    }

}