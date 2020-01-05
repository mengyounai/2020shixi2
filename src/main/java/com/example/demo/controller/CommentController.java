package com.example.demo.controller;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Comment;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.AnimeForm;
import com.example.demo.form.CommentForm;
import com.example.demo.reposipory.CommentRepository;
import com.example.demo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/user/comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository repository;

    @PostMapping("/save")
    public ModelAndView save(@Valid CommentForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/bangumi/user/anime/list");
            return new ModelAndView("common/error");
        }

        Random random = new Random();
        Integer key = random.nextInt(1000);
        Comment comment = new Comment();

        try {
            form.setCommentId(key);
            BeanUtils.copyProperties(form, comment);
            repository.save(comment);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/bangumi/user/detail/detail?animeId="+1);
            return new ModelAndView("common/error", map);
        }

        Integer id = comment.getAnimeId();

        map.put("url", "/bangumi/user/anime/detail?animeId=" + id);
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/down")
    public ModelAndView down(@RequestParam("commentId") Integer commentId,
                             @RequestParam(value = "userId",defaultValue = "1") Integer userId,
                             Map<String, Object> map) {

        Comment comment;
        try {
            comment=commentService.cancel(commentId);
        }
        catch (SellException e){
            log.error("[用户取消评论] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/anime/list");
            return new ModelAndView("common/error",map);
        }
        Comment comment1=repository.getOne(commentId);
        map.put("msg", ResultEnum.COLLECTION_CANCEL_SUCCESS.getMessage());
        map.put("url","/bangumi/user/anime/detail?animeId="+comment1.getAnimeId());

        return new ModelAndView("common/success",map);
    }
}
