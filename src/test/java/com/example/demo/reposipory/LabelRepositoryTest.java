package com.example.demo.reposipory;

import com.example.demo.dataobject.Label;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LabelRepositoryTest {

    @Autowired
    private LabelRepository repository;

    @Test
    public void findOneTest(){

        Label label=repository.getOne(1);

        if (label != null) {
            System.out.println(label);
        }
    }

    @Test
    public void saveTest(){

        Label label=new Label();
        label.setLabelId(6);
        label.setLabelName("励志");
        label.setLabelType(6);

        Label result=repository.save(label);
    }

    @Test
    public void findByLabelTypeInTest(){
        List<Integer> typeList= Arrays.asList(1,2,3,7);
        List<Label> labelList=repository.findByLabelTypeIn(typeList);

        log.info("[类型数量为] number={}",labelList.size());
        assertNotEquals(0,labelList.size());
    }
}