package com.example.demo.service.impl;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.Label;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.LabelRepository;
import com.example.demo.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeInfoRepository repository;

    @Autowired
    private AnimeService animeService;

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public AnimeInfo findOne(Integer animeId) {
        return repository.findById(animeId).orElse(null);
    }

    @Override
    public List<AnimeInfo> findOne2(Integer labelTypeList) {
        return repository.findByLabelType(labelTypeList);
    }

    @Override
    public List<AnimeInfo> findOne3(String labelName) {
        Label label=labelRepository.findByLabelName(labelName);
        List<AnimeInfo> animeInfoList=animeService.findOne2(label.getLabelType());
        return animeInfoList;
    }

    @Override
    public List<AnimeInfo> findOne4(String time) {
        return null;
    }

    @Override
    public List<String> labelAll() {
        List<AnimeInfo> upAll = animeService.findUpAll();

        boolean result=true;
        List<Integer> labelList=new ArrayList<>();
                for (AnimeInfo animeInfo:upAll){
                    for (Integer temp:labelList) {
                    if (animeInfo.getLabelType() == temp) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
              }
            if (result) {
                labelList.add(animeInfo.getLabelType());
            }
        }
        List<String> labelAll=new ArrayList<>();
        for (Integer a:labelList){
            String label=labelRepository.findByLabelType(a).getLabelName();
            labelAll.add(label);
        }
        return labelAll;
    }

    @Override
    public List<Integer> timeAll() {
        List<AnimeInfo> upAll = animeService.findUpAll();


        List<Integer> timeAll=new ArrayList<>();
        for (AnimeInfo animeInfo:upAll){
            boolean a=true;
            String time=animeInfo.getAnimeTime().substring(0,4);

            int time2=Integer.parseInt(time);

            for (Integer time3:timeAll){
                if (time2==time3){
                    a=false;
                    break;
                }
            }
            if (a){
                timeAll.add(time2);
            }

        }
        return timeAll;
    }

    @Override
    public Collection save(Integer userId) {
        return null;
    }

    @Override
    public Page<AnimeInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<AnimeInfo> findUpAll() {
        return repository.findByAnimeStatus(1);
    }

    @Override
    public Page<AnimeInfo> findUpAll(Pageable pageable) {
        Page<AnimeInfo> animeInfoPage=repository.findByAnimeStatus(0,pageable);
        return animeInfoPage;
    }

    @Override
    public AnimeInfo save(AnimeInfo animeInfo) {
        return repository.save(animeInfo);
    }

    @Override
    public AnimeInfo Up(Integer animeId) {
        AnimeInfo animeInfo=repository.findById(animeId).orElse(null);
        if (animeInfo.getAnimeStatus()==0){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        animeInfo.setAnimeStatus(0);
        return repository.save(animeInfo);
    }

    @Override
    public AnimeInfo down(Integer animeId) {

        AnimeInfo animeInfo=repository.findById(animeId).orElse(null);
        if (animeInfo.getAnimeStatus()==1){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        animeInfo.setAnimeStatus(1);
        return repository.save(animeInfo);
    }
}
