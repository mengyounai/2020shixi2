package com.example.demo.reposipory;

import com.example.demo.VO.CommentVO;
import com.example.demo.dataobject.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

        Page<Comment> findByAnimeId(Integer animeId, Pageable pageable);

        Comment findByAnimeIdAndUserId(Integer userId, Integer pageable);

//        Comment findByAnimeId(Integer animeId);


        List<Comment> findByCommentStatus(Integer status);


        List<Comment> findByAnimeId(Integer animeId);

        List<Comment> findByBookId(Integer bookId);

        List<Comment> findByMusicId(Integer musicId);

        List<Comment> findByPeopleId(Integer peopleId);
}
