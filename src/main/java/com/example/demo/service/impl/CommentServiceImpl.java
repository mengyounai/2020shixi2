package com.example.demo.service.impl;

import com.example.demo.VO.CommentVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Comment;
import com.example.demo.dataobject.UserInfo;
import com.example.demo.dto.AnimeDTO;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.CommentRepository;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;
import com.example.demo.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AnimeInfoRepository animeInfoRepository;

    @Autowired
    private UserService userService;

    String commentId = KeyUtil.genUniquKey();


    @Override
    public List<Comment> commentupAll() {
        return commentRepository.findByCommentStatus(1);
    }

    @Override
    public AnimeDTO create(AnimeDTO animeDTO) {


        Random random = new Random();
        Integer key = random.nextInt(100);
        Comment comment = new Comment();
        comment.setCommentId("10");
        BeanUtils.copyProperties(animeDTO, comment);

        commentRepository.save(comment);

        return animeDTO;
    }

    @Override
    public Comment animecreate(Integer userId, Integer animeId, String comment) {

        List<Comment> commentList = commentService.commentupAll();

        Comment comment1 = new Comment();

        boolean a = true;

        for (Comment comment2 : commentList) {
            if (comment2.getAnimeId() == animeId && comment2.getUserId() == userId) {
                a = false;
                comment1 = comment2;
                comment1.setCommentStatus(1);
                comment1.setCommentDescription(comment);
            }
        }

        if (a) {
            comment1.setCommentId(commentId);
            comment1.setUserId(userId);
            comment1.setAnimeId(animeId);
            comment1.setCommentStatus(1);
            comment1.setCommentDescription(comment);
        }

        commentRepository.save(comment1);


        return comment1;
    }

    @Override
    public List<Comment> animeAll(Integer animeId) {
        return commentRepository.findByAnimeId(animeId);
    }

    @Override
    public List<CommentVO> animeAll2(Integer animeId) {

        List<CommentVO> commentVOList = new ArrayList<>();

        List<CommentVO> commentVOList2 = new ArrayList<>();

        List<Comment> commentList = commentService.animeAll(animeId);
        for (Comment comment : commentList) {
            UserInfo userInfo = new UserInfo();
            CommentVO commentVO = new CommentVO();
            userInfo = userService.findbyuserId(comment.getUserId());
            BeanUtils.copyProperties(comment, commentVO);
            commentVO.setUserIcon(userInfo.getUserIcon());
            commentVO.setUserName(userInfo.getUserName());
            commentVOList.add(commentVO);
        }
        for (CommentVO commentVO : commentVOList) {
            CommentVO commentVO2 = new CommentVO();
            if (commentVO.getCommentDescription() == null || commentVO.getCommentDescription().equalsIgnoreCase("")) {

            } else {
                commentVO2 = commentVO;
                commentVOList2.add(commentVO2);
            }
        }


        return commentVOList2;
    }

    @Override
    public Comment bookcreate(Integer userId, Integer bookId, String comment) {
        List<Comment> commentList = commentService.commentupAll();

        Comment comment1 = new Comment();

        boolean a = true;

        for (Comment comment2 : commentList) {
            if (comment2.getBookId() == bookId && comment2.getUserId() == userId) {
                a = false;
                comment1 = comment2;
                comment1.setCommentStatus(1);
                comment1.setCommentDescription(comment);
            }
        }

        if (a) {
            comment1.setCommentId(commentId);
            comment1.setUserId(userId);
            comment1.setBookId(bookId);
            comment1.setCommentStatus(1);
            comment1.setCommentDescription(comment);
        }

        commentRepository.save(comment1);


        return comment1;
    }

    @Override
    public List<Comment> bookAll(Integer bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Override
    public List<CommentVO> bookAll2(Integer bookId) {
        List<CommentVO> commentVOList = new ArrayList<>();

        List<CommentVO> commentVOList2 = new ArrayList<>();

        List<Comment> commentList = commentService.bookAll(bookId);
        for (Comment comment : commentList) {
            UserInfo userInfo = new UserInfo();
            CommentVO commentVO = new CommentVO();
            userInfo = userService.findbyuserId(comment.getUserId());
            BeanUtils.copyProperties(comment, commentVO);
            commentVO.setUserIcon(userInfo.getUserIcon());
            commentVO.setUserName(userInfo.getUserName());
            commentVOList.add(commentVO);

        }
        for (CommentVO commentVO : commentVOList) {
            CommentVO commentVO2 = new CommentVO();
            if (commentVO.getCommentDescription() == null || commentVO.getCommentDescription().equalsIgnoreCase("")) {

            } else {
                commentVO2 = commentVO;
                commentVOList2.add(commentVO2);
            }
        }

        return commentVOList2;

    }

    @Override
    public Comment musiccreate(Integer userId, Integer musicId, String comment) {
        List<Comment> commentList = commentService.commentupAll();

        Comment comment1 = new Comment();

        boolean a = true;

        for (Comment comment2 : commentList) {
            if (comment2.getMusicId() == musicId && comment2.getUserId() == userId) {
                a = false;
                comment1 = comment2;
                comment1.setCommentStatus(1);
                comment1.setCommentDescription(comment);
            }
        }

        if (a) {
            comment1.setCommentId(commentId);
            comment1.setUserId(userId);
            comment1.setMusicId(musicId);
            comment1.setCommentStatus(1);
            comment1.setCommentDescription(comment);
        }

        commentRepository.save(comment1);

        return comment1;
    }

    @Override
    public List<Comment> musicAll(Integer musicId) {
        return commentRepository.findByMusicId(musicId);
    }

    @Override
    public List<CommentVO> musicAll2(Integer musicId) {
        List<CommentVO> commentVOList = new ArrayList<>();

        List<CommentVO> commentVOList2 = new ArrayList<>();

        List<Comment> commentList = commentService.musicAll(musicId);
        for (Comment comment : commentList) {
            UserInfo userInfo = new UserInfo();
            CommentVO commentVO = new CommentVO();
            userInfo = userService.findbyuserId(comment.getUserId());
            BeanUtils.copyProperties(comment, commentVO);
            commentVO.setUserIcon(userInfo.getUserIcon());
            commentVO.setUserName(userInfo.getUserName());
            commentVOList.add(commentVO);

        }
        for (CommentVO commentVO : commentVOList) {
            CommentVO commentVO2 = new CommentVO();
            if (commentVO.getCommentDescription() == null || commentVO.getCommentDescription().equalsIgnoreCase("")) {

            } else {
                commentVO2 = commentVO;
                commentVOList2.add(commentVO2);
            }
        }

        return commentVOList2;


    }

    @Override
    public Comment peoplecreate(Integer userId, Integer peopleId, String comment) {

        Comment comment1 = new Comment();

        comment1.setCommentId(commentId);
        comment1.setUserId(userId);
        comment1.setPeopleId(peopleId);
        comment1.setCommentStatus(1);
        comment1.setCommentDescription(comment);

        commentRepository.save(comment1);

        return comment1;
    }

    @Override
    public List<Comment> peopleAll(Integer peopleId) {
        return commentRepository.findByPeopleId(peopleId);
    }

    @Override
    public List<CommentVO> peopleAll2(Integer peopleId) {
        List<CommentVO> commentVOList = new ArrayList<>();

        List<CommentVO> commentVOList2 = new ArrayList<>();

        List<Comment> commentList = commentService.peopleAll(peopleId);
        for (Comment comment : commentList) {
            UserInfo userInfo = new UserInfo();
            CommentVO commentVO = new CommentVO();
            userInfo = userService.findbyuserId(comment.getUserId());
            BeanUtils.copyProperties(comment, commentVO);
            commentVO.setUserIcon(userInfo.getUserIcon());
            commentVO.setUserName(userInfo.getUserName());
            commentVOList.add(commentVO);

        }
        for (CommentVO commentVO : commentVOList) {
            CommentVO commentVO2 = new CommentVO();
            if (commentVO.getCommentDescription() == null || commentVO.getCommentDescription().equalsIgnoreCase("")) {

            } else {
                commentVO2 = commentVO;
                commentVOList2.add(commentVO2);
            }
        }

        return commentVOList2;
    }

    @Override
    public Page<Comment> findAll(Integer animeId, Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findByAnimeId(animeId, pageable);

        return commentPage;
    }

    @Override
    public Comment cancel(Integer commentId) {

        Comment byAnimeId = commentRepository.findById(commentId).orElse(null);
        if (byAnimeId == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        byAnimeId.setCommentStatus(1);
        Comment comment = commentRepository.save(byAnimeId);

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
