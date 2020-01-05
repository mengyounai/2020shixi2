package com.example.demo.reposipory;

import com.example.demo.dataobject.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,String> {

    List<Detail> findByCollectionId(String collectionId);
}
