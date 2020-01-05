package com.example.demo.service;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Label;

import java.util.List;

public interface LabelService {

    //管理员查询一个类目、查询所有类目、新增与修改工作
    Label findone(Integer labelId);
    List<Label> findAll();
    Label save(Label label);

    //用户根据标签查询类目
    List<Label> findLabelTypeIn(List<Integer> labelTypeList);

    //用户根据标签查询动漫
    List<AnimeInfo> findLabelType(Integer labelTypeList);

    //用户根据标签查询书籍
    List<BookInfo> findLabelType2(List<Integer> labelTypeList);

    //查询所有与动漫表对应的标签条目
    List<Label> labelList();

}
