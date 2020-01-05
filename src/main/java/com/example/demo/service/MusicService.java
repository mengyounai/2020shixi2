package com.example.demo.service;

import com.example.demo.dataobject.MusicInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicService {

    //根据id查询音乐
    MusicInfo findOne(Integer musicId);

    //根据类型查询音乐
    List<MusicInfo> findOne2(Integer labelType);

    //根据类型名字查询音乐
    List<MusicInfo> findOne3(String labelName);

    //根据出版时间查询音乐
    List<MusicInfo> findOne4(String time);

    //查询所有条目
    List<String> labelAll();

    //查询所有时间
    List<Integer> timeAll();

    //查询所有动漫
    Page<MusicInfo> findAll(Pageable pageable);

    //查询所有在架音乐
    List<MusicInfo> findUpAll();

    //查询所有在架音乐
    Page<MusicInfo> findUpAll(Pageable pageable);

    //新增音乐
    MusicInfo save(MusicInfo musicInfo);

    //上架音乐
    MusicInfo Up(Integer musicId);

    //下架音乐
    MusicInfo down(Integer musicId);
}
