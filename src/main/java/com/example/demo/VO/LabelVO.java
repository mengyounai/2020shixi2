package com.example.demo.VO;

import lombok.Data;

import java.util.List;

@Data
public class LabelVO {

    private String labelName;

    private Integer labelType;

    private List<LabelInfoVO> labelInfoVOList;
}
