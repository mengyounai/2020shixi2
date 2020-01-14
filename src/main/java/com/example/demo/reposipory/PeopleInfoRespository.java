package com.example.demo.reposipory;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.PeopleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleInfoRespository extends JpaRepository<PeopleInfo,Integer> {

    List<PeopleInfo> findByAnimeId(Integer animeId);

    //根据人物Id查询单个人物
    PeopleInfo findByPeopleId(Integer peopleId);

    //查询人物状态查询人物列表
    List<PeopleInfo> findByPeopleStatus(Integer status);

//    //根据人物生日查询人物列表
//    @Query("select p from AnimeInfo p where p.peopleBirthday like %:name%")
//    public List<AnimeInfo> queryLike2(@Param("name") String time);


}
