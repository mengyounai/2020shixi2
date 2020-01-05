package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.conveter.CollectFoem2CollectionDTOConverter;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.CollectForm;
import com.example.demo.service.CollectionService;
import com.example.demo.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/order")
@Slf4j
@Api(description = "用户端收藏相关操作接口",produces = "application/json")
public class UserCollectionController {

    @Autowired
    private CollectionService collectionService;

    //创建收藏
    @ApiOperation(value = "创建收藏",notes = "用户端收藏")
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid CollectForm collectForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("[创建收藏]收藏参数不正确,collectForm={}",collectForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        CollectionDTO collectionDTO= CollectFoem2CollectionDTOConverter.convert(collectForm);

        if (CollectionUtils.isEmpty(collectionDTO.getDetailList())){
            log.error("[创建收藏]收藏内容不能为空");
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        CollectionDTO createResult=collectionService.create(collectionDTO);

        Map<String,String> map=new HashMap<>();
        map.put("collectId",createResult.getCollectionId());

        return ResultVOUtil.success(map);
    }

    //收藏列表
    @ApiOperation(value = "收藏列表",notes = "根据用户userId，以及分页信息显示某一页的订单列表")
    @GetMapping("/list")
    public ResultVO<List<CollectionDTO>> list(@RequestParam("userId") Integer userId,
                                              @RequestParam(value = "page",defaultValue = "0") Integer page,
                                              @RequestParam(value = "size",defaultValue = "5") Integer size){

        if (StringUtils.isEmpty(userId)){
            log.error("[查询收藏列表]买家userid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Page<CollectionDTO> collectionDTOPage=collectionService.findAll(userId, PageRequest.of(page,size));

        return ResultVOUtil.success(collectionDTOPage.getContent());
    }

    //取消收藏
    @ApiOperation(value = "取消收藏",notes = "根据用户userId和收藏id取消收藏")
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam String userId,
                           @RequestParam String collectId){

        return null;
    }

    @ApiOperation(value = "收藏详情",notes = "根据用户userId和收藏id查询收藏")
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam String userId,
                           @RequestParam String collectId){

        return null;
    }

}
