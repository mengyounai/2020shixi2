package com.example.demo.reposipory;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimeInfoRepository extends JpaRepository<AnimeInfo,Integer> {

    public List<AnimeInfo> findByAnimeStatus(Integer animeStatus);

    public Page<AnimeInfo> findByAnimeStatus(Integer animeStatus, Pageable pageable);

    //根据动画id查询动画
    List<AnimeInfo> findByAnimeId(String animeId);

    //根据动画id查询单个动画
    AnimeInfo findByAnimeId(Integer animeId);

    //根据动画类型查询动画
    public List<AnimeInfo> findByLabelType(Integer labelTypeList);

    //根据动画出版时间查询动画
    public List<AnimeInfo> findByAnimeTime(String time);



    @Query("select p from AnimeInfo p where p.animeName like %:name%")
    public List<AnimeInfo> queryLike(@Param("name") String name);

    @Query("select p from AnimeInfo p where p.animeTime like %:name%")
    public List<AnimeInfo> queryLike2(@Param("name") String time);
}
