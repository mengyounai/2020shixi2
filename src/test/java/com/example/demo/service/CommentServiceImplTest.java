package com.example.demo.service;

import com.example.demo.dataobject.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void create() {
    }

    @Test
    public void findAll() {
        Page<Comment> all = commentService.findAll(11, PageRequest.of(0, 10));
        log.info("[评论总数] number={}",all.getTotalElements());
    }

    @Test
    public void cancel() {
    }
}