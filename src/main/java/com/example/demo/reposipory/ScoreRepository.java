package com.example.demo.reposipory;

import com.example.demo.dataobject.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

    //根据动画id查询动漫评分
    Page<Score> findByAnimeId(Integer animeId, Pageable Pageable);

    List<Score> findByAnimeId(Integer animeId);

    //根据书籍id查询书籍评分
    Page<Score> findByBookId(Integer bookId, Pageable Pageable);

    List<Score> findByBookId(Integer bookId);

    //根据音乐id查询音乐评分
    Page<Score> findByMusicId(Integer musicId, Pageable Pageable);

    List<Score> findByMusicId(Integer musicId);

}
