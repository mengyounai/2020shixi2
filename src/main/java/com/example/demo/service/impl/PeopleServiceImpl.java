package com.example.demo.service.impl;

import com.example.demo.VO.PeopleVO;
import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.reposipory.PeopleInfoRespository;
import com.example.demo.service.PeopleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleInfoRespository respository;

    @Override
    public PeopleInfo findOne(Integer peopleId) {

        PeopleInfo peopleInfo=respository.findById(peopleId).orElse(null);
        return peopleInfo;
    }

    @Override
    public Page<PeopleInfo> findAll(Pageable pageable) {

        Page<PeopleInfo> peopleInfoPage=respository.findAll(pageable);
        return peopleInfoPage;
    }

    @Override
    public List<PeopleInfo> peopleAll(Integer animeId) {
        return respository.findByAnimeId(animeId);
    }

    @Override
    public List<PeopleVO> peoplelist(Integer status) {
        List<PeopleInfo> peopleInfoList=respository.findByPeopleStatus(status);

        List<PeopleVO> peopleVOList=new ArrayList<>();
        for (PeopleInfo peopleInfo:peopleInfoList){
            PeopleVO peopleVO=new PeopleVO();
            BeanUtils.copyProperties(peopleInfo,peopleVO);
            peopleVOList.add(peopleVO);
        }

        return peopleVOList;
    }
}
