package com.example.demo.reposipory;

import com.example.demo.dataobject.Detail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DetailRepositoryTest {

    @Autowired
    private DetailRepository repository;

    @Test
    public void saveTest(){

        Detail detail=new Detail();
        detail.setAnimeId(1);
        detail.setCollectionId("1");
        detail.setDetailId("1");

        Detail result=repository.save(detail);
        assertNotNull(result);
    }

    @Test
    public void findByCollectionId() {

        List<Detail> result=repository.findByCollectionId("1");
        assertEquals(1,result);

    }
}