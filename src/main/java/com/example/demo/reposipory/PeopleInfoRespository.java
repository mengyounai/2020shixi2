package com.example.demo.reposipory;

import com.example.demo.dataobject.PeopleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleInfoRespository extends JpaRepository<PeopleInfo,Integer> {

    List<PeopleInfo> findByAnimeId(Integer animeId);


}
