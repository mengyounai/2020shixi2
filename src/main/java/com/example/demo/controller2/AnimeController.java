package com.example.demo.controller2;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.CommentVO;
import com.example.demo.VO.RateVO;
import com.example.demo.dataobject.*;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.ScoreRepository;
import com.example.demo.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anime")
@Api(description = "动漫信息相关操作接口")
@CrossOrigin
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private AnimeInfoRepository animeInfoRepository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/list")
    public List<AnimeVO> list(){

        //1.查询所有上架动漫
        List<AnimeInfo> animeInfoList=animeService.findUpAll();

        List<AnimeVO> animeVOList=new ArrayList<>();

        List<Score> scoreList=scoreRepository.findAll();

        List<Score> scoresum=new ArrayList<>();
        for (AnimeInfo animeInfo:animeInfoList){
            AnimeVO animeVO=new AnimeVO();
            BeanUtils.copyProperties(animeInfo,animeVO);
            animeVOList.add(animeVO);
        }
        Integer index=-1;
        for (AnimeVO animeVO:animeVOList){
            index++;
            for (Score score:scoreList){
                if (animeVO.getAnimeId()==score.getAnimeId()){
                    double score1=scoreService.score(animeVO.getAnimeId());
                    Integer number=scoreRepository.findByAnimeId(animeVO.getAnimeId()).size();
                    animeVOList.get(index).setScore(score1);
                    animeVOList.get(index).setNumber(number);
                }
            }
        }

        return animeVOList;
    }

    @GetMapping("type")
    public List<String> labelAll(){

        List<String> labelAll=animeService.labelAll();
        return labelAll;
    }

    @GetMapping("time")
    public List<Integer> timeAll(){

        List<Integer> timeAll=animeService.timeAll();
        Collections.sort(timeAll);
        return timeAll;
    }

    @RequestMapping("/people")
    @ResponseBody
    public List<PeopleInfo> peopleAll(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();

        Integer animeId2=Integer.parseInt(animeId);
        List<PeopleInfo> peopleInfoList=peopleService.peopleAll(animeId2);

        return peopleInfoList;

    }


    @RequestMapping("/type")
    @ResponseBody
    public List<AnimeVO> animeInfoList(@RequestBody Map<String, Object> info){

        String bookName= info.get("bookName").toString();

        List<Score> scoreList=scoreRepository.findAll();

        List<AnimeInfo> animeInfoList=animeService.findOne3(bookName);
        List<AnimeVO> animeVOList=new ArrayList<>();

        for (AnimeInfo animeInfo:animeInfoList){
            AnimeVO animeVO=new AnimeVO();
            BeanUtils.copyProperties(animeInfo,animeVO);
            animeVOList.add(animeVO);
        }

        Integer index=-1;
        for (AnimeVO animeVO:animeVOList){
            index++;
            for (Score score:scoreList){
                if (animeVO.getAnimeId()==score.getAnimeId()){
                    double score1=scoreService.score(animeVO.getAnimeId());
                    Integer number=scoreRepository.findByAnimeId(animeVO.getAnimeId()).size();
                    animeVOList.get(index).setScore(score1);
                    animeVOList.get(index).setNumber(number);
                }
            }
        }

        return animeVOList;
    }

    @RequestMapping("/time")
    @ResponseBody
    public List<AnimeVO> animeInfoList2(@RequestBody Map<String, Object> info){

        String time= info.get("time").toString();

        List<Score> scoreList=scoreRepository.findAll();

        List<AnimeInfo> animeInfoList=animeInfoRepository.queryLike2(time);

        List<AnimeVO> animeVOList=new ArrayList<>();

        for (AnimeInfo animeInfo:animeInfoList){
            AnimeVO animeVO=new AnimeVO();
            BeanUtils.copyProperties(animeInfo,animeVO);
            animeVOList.add(animeVO);
        }

        Integer index=-1;
        for (AnimeVO animeVO:animeVOList){
            index++;
            for (Score score:scoreList){
                if (animeVO.getAnimeId()==score.getAnimeId()){
                    double score1=scoreService.score(animeVO.getAnimeId());
                    Integer number=scoreRepository.findByAnimeId(animeVO.getAnimeId()).size();
                    animeVOList.get(index).setScore(score1);
                    animeVOList.get(index).setNumber(number);
                }
            }
        }

        return  animeVOList;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public AnimeVO animeDetail(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();

        Integer animeId2=Integer.parseInt(animeId);

        AnimeInfo animeInfo=animeService.findOne(animeId2);

        AnimeVO animeVO=new AnimeVO();

        BeanUtils.copyProperties(animeInfo,animeVO);

        double score=scoreService.score(animeId2);

        animeVO.setScore(score);

        return animeVO;
    }

    @RequestMapping("/discuss")
    @ResponseBody
    public List<CommentVO> commentVOList(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();
        Integer animeId2=Integer.parseInt(animeId);

        List<CommentVO> commentVOList=commentService.animeAll2(animeId2);
        return commentVOList;
    }

    @RequestMapping("/collect")
    @ResponseBody
    public boolean collect(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();
        Integer animeId2=Integer.parseInt(animeId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String code= info.get("code").toString();
        Integer code2=Integer.parseInt(code);

        String comment= info.get("comment").toString();

        collectionService.animecreate(userId2,code2,animeId2);

        commentService.animecreate(userId2,animeId2,comment);

        return true;

    }

    @RequestMapping("/rate")
    @ResponseBody
    public RateVO rate(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();
        Integer animeId2=Integer.parseInt(animeId);

        RateVO rateVO=scoreService.scorelist(animeId2);

        return rateVO;

    }

    @RequestMapping("/rateup")
    @ResponseBody
    public Boolean rateup(@RequestBody Map<String, Object> info){

        String animeId= info.get("animeId").toString();
        Integer animeId2=Integer.parseInt(animeId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String score= info.get("score").toString();
        double score2=Double.valueOf(score);

        Score score1=scoreService.animescore(animeId2,userId2,score2);

        return true;

    }
}
