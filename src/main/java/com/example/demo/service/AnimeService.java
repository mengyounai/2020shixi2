package com.example.demo.service;

import com.example.demo.VO.AnimeVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimeService {

    //根据id查询动漫
    AnimeInfo findOne(Integer animeId);

    //模糊查询动漫
    List<AnimeVO> search(Integer userId,String animeName);

    //根据类型查询动漫
    List<AnimeInfo> findOne2(Integer labelType);

    //根据类型名字查询动漫
    List<AnimeInfo> findOne3(String labelName);

    //根据出版时间查询动漫
    List<AnimeInfo> findOne4(String time);

    //查询所有条目
    List<String> labelAll();

    //查询所有时间
    List<Integer> timeAll();

    //收藏动漫
    Collection save(Integer userId);

    //查询所有动漫
    Page<AnimeInfo> findAll(Pageable pageable);

    //查询所有在架动漫
    List<AnimeInfo> findUpAll();

    //查询所有在架动漫
    Page<AnimeInfo> findUpAll(Pageable pageable);

    //新增动漫
    AnimeInfo save(AnimeInfo animeInfo);

    //上架动漫
    AnimeInfo Up(Integer animeId);

    //下架动漫
    AnimeInfo down(Integer animeId);
}
