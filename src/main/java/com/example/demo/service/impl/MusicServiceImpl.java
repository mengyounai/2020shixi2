package com.example.demo.service.impl;

import com.example.demo.dataobject.Label;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.LabelRepository;
import com.example.demo.reposipory.MusicInfoRespository;
import com.example.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicInfoRespository repository;

    @Autowired
    private MusicService musicService;

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public MusicInfo findOne(Integer musicId) {
        return repository.findById(musicId).orElse(null);
    }

    @Override
    public List<MusicInfo> findOne2(Integer labelTypeList) {
        return repository.findByLabelType(labelTypeList);
    }

    @Override
    public List<MusicInfo> findOne3(String labelName) {
        Label label=labelRepository.findByLabelName(labelName);
        List<MusicInfo> musicInfoList=musicService.findOne2(label.getLabelType());
        return musicInfoList;
    }

    @Override
    public List<MusicInfo> findOne4(String time) {
        return null;
    }

    @Override
    public List<String> labelAll() {
        List<MusicInfo> upAll = musicService.findUpAll();

        boolean result=true;
        List<Integer> labelList=new ArrayList<>();
        for (MusicInfo musicInfo:upAll){
            for (Integer temp:labelList) {
                if (musicInfo.getLabelType() == temp) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
            if (result) {
                labelList.add(musicInfo.getLabelType());
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
        List<MusicInfo> upAll = musicService.findUpAll();


        List<Integer> timeAll=new ArrayList<>();
        for (MusicInfo musicInfo:upAll){
            boolean a=true;
            String time=musicInfo.getMusicTime().substring(0,4);

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
    public Page<MusicInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<MusicInfo> findUpAll() {
        return repository.findByMusicStatus(1);
    }

    @Override
    public Page<MusicInfo> findUpAll(Pageable pageable) {
        Page<MusicInfo> musicInfoPage=repository.findByMusicStatus(0,pageable);
        return musicInfoPage;
    }

    @Override
    public MusicInfo save(MusicInfo musicInfo) {
        return repository.save(musicInfo);
    }

    @Override
    public MusicInfo Up(Integer musicId) {
        MusicInfo musicInfo=repository.findById(musicId).orElse(null);
        if (musicInfo.getMusicStatus()==0){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        musicInfo.setMusicStatus(0);
        return repository.save(musicInfo);
    }

    @Override
    public MusicInfo down(Integer musicId) {

        MusicInfo musicInfo=repository.findById(musicId).orElse(null);
        if (musicInfo.getMusicStatus()==1){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        musicInfo.setMusicStatus(1);
        return repository.save(musicInfo);
    }
}
