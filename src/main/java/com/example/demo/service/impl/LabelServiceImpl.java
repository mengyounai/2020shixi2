package com.example.demo.service.impl;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Label;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.LabelRepository;
import com.example.demo.service.AnimeService;
import com.example.demo.service.LabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository repository;

    @Autowired
    private AnimeService animeService;

    @Override
    public Label findone(Integer labelId) {
        return repository.findById(labelId).orElse(null);
    }

    @Override
    public List<Label> findAll() {
        return repository.findAll();
    }

    @Override
    public Label save(Label label) {
        return repository.save(label);
    }

    @Override
    public List<Label> findLabelTypeIn(List<Integer> labelTypeList) {
        return repository.findByLabelTypeIn(labelTypeList);
    }

    @Override
    public List<AnimeInfo> findLabelType(Integer labelTypeList) {

       return animeService.findOne2(labelTypeList);
    }

    @Override
    public List<BookInfo> findLabelType2(List<Integer> labelTypeList) {
        return null;
    }

    @Override
    public List<Label> labelList() {

//        List<Integer> labelList=animeService.labelAll();
//
//        List<Label> label=repository.findByLabelTypeIn(labelList);
//
//        if (label==null){
//            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//        }


        return null;
    }
}
