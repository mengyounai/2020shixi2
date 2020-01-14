package com.example.demo.service;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.BookVO;
import com.example.demo.VO.MusicVO;
import com.example.demo.VO.PeopleVO;
import com.example.demo.dataobject.*;
import com.example.demo.dto.CollectionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CollectionService {


    // 查询所有收藏
    List<Collection> collectAll();

//    收藏动漫
    CollectionDTO create(CollectionDTO collectionDTO);

    //收藏书籍
    CollectionDTO create2(CollectionDTO collectionDTO);

    //收藏音乐
    CollectionDTO create3(CollectionDTO collectionDTO);

    //收藏动漫
    Collection animecreate(Integer userId,Integer code,Integer animeId);

    //收藏书籍
    Collection bookcreate(Integer userId,Integer code,Integer bookId);

    //收藏音乐
    Collection musiccreate(Integer userId,Integer code,Integer musicId);

    //收藏人物
    Collection peoplecreate(Integer userId,Integer code,Integer peopleId);


    //查询所有收藏
    Page<CollectionDTO> findAll(Integer userId, Pageable pageable);

    //查询单个收藏
    CollectionDTO f(String collectionId);

    //查询所有动漫收藏
    Page<CollectionDTO> findAnimeAll(Integer userId, Pageable pageable);

    //查询所有书籍收藏
    Page<CollectionDTO> findBookAll(Integer userId, Pageable pageable);

    //查询所有音乐收藏
    Page<CollectionDTO> findMusicAll(Integer userId, Pageable pageable);

    //查询所有人物收藏
    Page<CollectionDTO> findPeopleAll(Integer userId, Pageable pageable);

    //取消收藏
    CollectionDTO cancel(CollectionDTO collectionDTO);

    //查询收藏列表
    Page<CollectionDTO> findList(Pageable pageable);

    //根据用户id查询收藏动漫
    List<AnimeInfo> findByuserId(Integer userid, Pageable Pageable);

    //根据用户id查询收藏书籍
    List<BookInfo> findByuserId2(Integer userid, Pageable Pageable);

    //根据用户id查询收藏音乐
    List<MusicInfo> findByuserId3(Integer userid, Pageable Pageable);

    //根据用户id查询收藏人物
    List<PeopleInfo> findByuserId4(Integer userid, Pageable Pageable);


    //分割线

    //查询单个用户所有动漫收藏
    List<AnimeVO> animecollect(Integer userId);

    //查询单个用户所有书籍收藏
    List<BookVO> bookcollect(Integer userId);

    //查询单个用户所有音乐收藏
    List<MusicVO> musiccollect(Integer userId);

    //查询单个用户所有人物收藏
    List<PeopleVO> peoplecollect(Integer userId);



}
