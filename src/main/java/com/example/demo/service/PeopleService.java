package com.example.demo.service;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.PeopleInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeopleService {

    //根据id查询人物
    PeopleInfo findOne(Integer peopleId);

    //查询所有人物
    Page<PeopleInfo> findAll(Pageable pageable);

    //根据动漫Id查询所有人物
    List<PeopleInfo> peopleAll(Integer animeId);

}
