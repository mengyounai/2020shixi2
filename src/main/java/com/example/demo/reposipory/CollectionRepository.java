package com.example.demo.reposipory;

import com.example.demo.dataobject.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection,String> {

    //根据用户id查询收藏
    Page<Collection> findByUserId(Integer userId, Pageable pageable);

    //根据动画id查询动漫
    Page<AnimeInfo> findByAnimeId(Integer animeId,Pageable Pageable);

    //根据书籍id查询书籍
    Page<BookInfo> findByBookId(Integer bookId, Pageable Pageable);

    //根据音乐id查询音乐
    Page<MusicInfo> findByMusicId(Integer musicId, Pageable Pageable);

    //根据人物id查询人物
    Page<PeopleInfo> findByPeopleId(Integer peopleId, Pageable Pageable);



    //分割线

    //根据用户id查询收藏
    List<Collection> findByUserId(Integer userId);




}
