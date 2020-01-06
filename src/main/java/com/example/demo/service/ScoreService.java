package com.example.demo.service;

import com.example.demo.VO.RateVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.dataobject.Score;
import com.example.demo.dto.CollectionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.DecimalFormat;
import java.util.List;

public interface ScoreService {

    //根据动画id查询动漫评分
    AnimeInfo findByAnimeId(Integer animeId);

    //根据动画id给每个评分分类
    RateVO scorelist(Integer animeId);

    //根据动画id评分
    Score animescore(Integer animeId,Integer userId,double score);


    //书籍

    //根据书籍id查询书籍评分
    BookInfo findByBookId(Integer bookId);

    //根据动画id给每个评分分类
    RateVO scorelist2(Integer bookId);

    //根据书籍id评分
    Score bookscore(Integer bookId,Integer userId,double score);


    //音乐

    //根据音乐id查询音乐评分
    MusicInfo findByMusicId(Integer musicId);

    RateVO scorelist3(Integer musicId);

    //根据音乐id评分
    Score musicscore(Integer musicId,Integer userId,double score);





    //统计单个动漫评分
    double score(Integer animeId);

    //统计单个书籍评分
    double score2(Integer bookId);

    //统计单个音乐评分
    double score3(Integer musicId);

    //统计所有动漫评分
    List<Double> scoresum();


    //查询所有动漫评分
    List<Score> findAnimeAll(Integer animeId);

    //查询所有书籍评分
    Page<Score> findBookAll(Integer bookId,Pageable pageable);

    //查询所有音乐评分
    Page<Score> findMusicAll(Integer musicId,Pageable pageable);
}
