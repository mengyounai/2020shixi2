package com.example.demo.service.impl;

import com.example.demo.dataobject.Label;
import com.sun.javafx.scene.control.skin.LabeledImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LabelServiceImplTest {

    @Autowired
    private LabelServiceImpl labelService;

    @Test
    public void findone() {
        Label label=labelService.findone(2);
        assertNotEquals(new Integer(0),label.getLabelId());
    }

    @Test
    public void findAll() {
        List<Label> labelList=labelService.findAll();
        assertNotEquals(0,labelList.size()==2);
    }

    @Test
    public void save() {
        Label label=new Label();
        label.setLabelId(7);
        label.setLabelName("后宫");
        label.setLabelType(7);

        Label result=labelService.save(label);

    }

    @Test
    public void findLabelAll(){
        List<Label> labelList = labelService.labelList();
        for (Label label:labelList){
            log.info("[标签名称] labelName={}",label.getLabelName());
        }

    }
}