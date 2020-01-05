package com.example.demo.reposipory;

import com.example.demo.dataobject.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionRepositoryTest {

    @Autowired
    private CollectionRepository repository;

    @Test
    public void saveTest(){
        Collection collection=new Collection();
        collection.setCollectionId("4");
        collection.setUserId(1);
        collection.setAnimeId(1);


        Collection result=repository.save(collection);
        assertNotNull(result);

    }
    @Test
    public void findByUserId() {
        Page<Collection> result=repository.findByUserId(1, PageRequest.of(0,2));
        assertNotNull(result);
    }


}