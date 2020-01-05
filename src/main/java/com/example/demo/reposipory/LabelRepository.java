package com.example.demo.reposipory;

import com.example.demo.dataobject.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LabelRepository extends JpaRepository<Label,Integer> {

    public List<Label> findByLabelTypeIn(List<Integer> labelType);

    public Label findByLabelType(Integer labelType);

    public Label findByLabelName(String labelName);
}
