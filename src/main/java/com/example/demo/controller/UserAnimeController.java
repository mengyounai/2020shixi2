package com.example.demo.controller;

import com.example.demo.VO.LabelInfoVO;
import com.example.demo.VO.LabelVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Label;
import com.example.demo.service.AnimeService;
import com.example.demo.service.LabelService;
import com.example.demo.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/product")
@Api(description = "用户端类目相关操作接口",produces = "application/json")
public class UserAnimeController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private LabelService labelService;

    @ApiOperation(value = "动漫列表",notes = "动漫列表信息")
    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有上架动漫
        List<AnimeInfo> animeInfoList=animeService.findUpAll();

        //查询类目
        List<Integer> labelLists=animeInfoList.stream()
                .map(e -> e.getLabelType())
                .collect(Collectors.toList());
        List<Label> labelList=labelService.findLabelTypeIn(labelLists);


        //3.数据拼装
        List<LabelVO> labelVOList=new ArrayList<>();

        for (Label label: labelList){
            LabelVO labelVO=new LabelVO();
            labelVO.setLabelName(label.getLabelName());
            labelVO.setLabelType(label.getLabelType());

            List<LabelInfoVO> labelInfoVOList=new ArrayList<>();
            for (AnimeInfo animeInfo:animeInfoList){
                if (animeInfo.getLabelType().equals(label.getLabelType())){
                    LabelInfoVO labelInfoVO=new LabelInfoVO();
                    BeanUtils.copyProperties(animeInfo,labelInfoVO);//前面的给后面的
                    labelInfoVOList.add(labelInfoVO);
                }
            }
            labelVO.setLabelInfoVOList(labelInfoVOList);
            labelVOList.add(labelVO);
        }

        return ResultVOUtil.success(labelVOList);
    }
}
