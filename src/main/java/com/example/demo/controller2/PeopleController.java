package com.example.demo.controller2;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.CommentVO;
import com.example.demo.VO.PeopleVO;
import com.example.demo.VO.PeopleVO1;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.service.AnimeService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.CommentService;
import com.example.demo.service.PeopleService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
@Api(description = "人物信息相关操作接口")
@CrossOrigin
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AnimeService animeService;

    @GetMapping("list")
    public List<PeopleVO1> list() {

        List<PeopleVO> peopleVOList1=new ArrayList<>();

        List<PeopleVO> peopleVOList2=new ArrayList<>();

        peopleVOList1=peopleService.peoplelist(2);
        peopleVOList2=peopleService.peoplelist(3);

        List<PeopleVO1> peopleVO1=new ArrayList<>();

        PeopleVO1 peopleVO11=new PeopleVO1();
        peopleVO11.setPeopleVOList(peopleVOList1);
        peopleVO1.add(peopleVO11);


        PeopleVO1 peopleVO12=new PeopleVO1();
        peopleVO12.setPeopleVOList(peopleVOList2);
        peopleVO1.add(peopleVO12);

        return peopleVO1;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public PeopleVO peopleDetail(@RequestBody Map<String, Object> info){

        String peopleId= info.get("peopleId").toString();

        Integer peopleId2=Integer.parseInt(peopleId);

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        PeopleInfo peopleInfo=peopleService.findOne(peopleId2);

        PeopleVO peopleVO=new PeopleVO();

        BeanUtils.copyProperties(peopleInfo,peopleVO);

        List<Collection> collectionList=collectionService.collectAll();
        for (Collection collection:collectionList){
            if (collection.getPeopleId()==peopleId2&&collection.getUserId()==userId2){
                peopleVO.setCollectStatus(collection.getCollectionStatus());
            }
        }

        return peopleVO;
    }

    @RequestMapping("/discuss")
    @ResponseBody
    public List<CommentVO> commentVOList(@RequestBody Map<String, Object> info){

        String peopleId= info.get("peopleId").toString();
        Integer peopleId2=Integer.parseInt(peopleId);

        List<CommentVO> commentVOList=commentService.peopleAll2(peopleId2);
        return commentVOList;
    }

    @RequestMapping("/anime")
    @ResponseBody
    public AnimeVO animeAll(@RequestBody Map<String, Object> info){

        String peopleId= info.get("peopleId").toString();

        Integer peopleId2=Integer.parseInt(peopleId);

        PeopleInfo peopleInfo=peopleService.findOne(peopleId2);
        AnimeInfo animeInfo=new AnimeInfo();
        AnimeVO animeVO=new AnimeVO();
        if (peopleInfo.getAnimeId()==null||peopleInfo.getAnimeId().equals("")){
            animeVO.setShow(false);
        }else{
            animeInfo=animeService.findOne(peopleInfo.getAnimeId());
            BeanUtils.copyProperties(animeInfo,animeVO);
            animeVO.setShow(true);

        }

        return animeVO;

    }

    @RequestMapping("/disUp")
    @ResponseBody
    public boolean disUp(@RequestBody Map<String, Object> info){

        String peopleId= info.get("peopleId").toString();
        Integer peopleId2=Integer.parseInt(peopleId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String comment= info.get("comment").toString();

        commentService.peoplecreate(userId2,peopleId2,comment);

        return true;

    }

    @RequestMapping("/collect")
    @ResponseBody
    public boolean collect(@RequestBody Map<String, Object> info){

        String peopleId= info.get("peopleId").toString();
        Integer peopleId2=Integer.parseInt(peopleId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String code= info.get("code").toString();
        Integer code2=Integer.parseInt(code);


        collectionService.peoplecreate(userId2,code2,peopleId2);

        return true;

    }

}
