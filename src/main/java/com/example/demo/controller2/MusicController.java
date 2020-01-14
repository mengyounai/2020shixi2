package com.example.demo.controller2;

import com.example.demo.VO.*;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.dataobject.Score;
import com.example.demo.reposipory.MusicInfoRespository;
import com.example.demo.reposipory.ScoreRepository;
import com.example.demo.service.CollectionService;
import com.example.demo.service.CommentService;
import com.example.demo.service.MusicService;
import com.example.demo.service.ScoreService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/music")
@Api(description = "音乐信息相关操作接口")
@CrossOrigin
public class MusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private MusicInfoRespository musicInfoRepository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list")
    @ResponseBody
    public List<MusicVO> list(@RequestBody Map<String, Object> info) {

        //1.查询所有上架动漫
        List<MusicInfo> musicInfoList=musicService.findUpAll();

        List<MusicVO> musicVOList=new ArrayList<>();

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        List<MusicVO> musicVOList1 = collectionService.musiccollect(userId2);

        List<Score> scoreList=scoreRepository.findAll();

        List<Score> scoresum=new ArrayList<>();
        for (MusicInfo musicInfo:musicInfoList){
            MusicVO musicVO=new MusicVO();
            BeanUtils.copyProperties(musicInfo,musicVO);
            musicVOList.add(musicVO);
        }
        Integer index=-1;
        for (MusicVO musicVO:musicVOList){
            index++;
            for (Score score:scoreList){
                if (musicVO.getMusicId()==score.getMusicId()){
                    double score1=scoreService.score3(musicVO.getMusicId());
                    Integer number=scoreRepository.findByMusicId(musicVO.getMusicId()).size();
                    musicVOList.get(index).setScore(score1);
                    musicVOList.get(index).setNumber(number);
                }
            }
        }

        for (MusicVO musicVO : musicVOList) {
            for (MusicVO musicVO1 : musicVOList1) {
                if (musicVO.getMusicId() == musicVO1.getMusicId()) {
                    musicVO.setCollectStatus(musicVO1.getCollectStatus());
                }
            }
        }
        for (MusicVO musicVO : musicVOList) {
            if (musicVO.getCollectStatus()!=0){
                musicVO.setShow3(false);
            }
        }

        return musicVOList;
    }

    @GetMapping("type")
    public List<String> labelAll(){

        List<String> labelAll=musicService.labelAll();
        return labelAll;
    }

    @GetMapping("time")
    public List<Integer> timeAll(){

        List<Integer> timeAll=musicService.timeAll();
        Collections.sort(timeAll);
        return timeAll;
    }

    @RequestMapping("/type")
    @ResponseBody
    public List<MusicVO> musicInfoList(@RequestBody Map<String, Object> info){

        String bookName= info.get("bookName").toString();

        List<Score> scoreList=scoreRepository.findAll();

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        List<MusicVO> musicVOList1 = collectionService.musiccollect(userId2);

        List<MusicInfo> musicInfoList=musicService.findOne3(bookName);

        List<MusicVO> musicVOList=new ArrayList<>();

        for (MusicInfo musicInfo:musicInfoList){
            MusicVO musicVO=new MusicVO();
            BeanUtils.copyProperties(musicInfo,musicVO);
            musicVOList.add(musicVO);
        }

        Integer index=-1;
        for (MusicVO musicVO:musicVOList){
            index++;
            for (Score score:scoreList){
                if (musicVO.getMusicId()==score.getMusicId()){
                    double score1=scoreService.score3(musicVO.getMusicId());
                    Integer number=scoreRepository.findByMusicId(musicVO.getMusicId()).size();
                    musicVOList.get(index).setScore(score1);
                    musicVOList.get(index).setNumber(number);
                }
            }
        }

        for (MusicVO musicVO : musicVOList) {
            for (MusicVO musicVO1 : musicVOList1) {
                if (musicVO.getMusicId() == musicVO1.getMusicId()) {
                    musicVO.setCollectStatus(musicVO1.getCollectStatus());
                }
            }
        }
        for (MusicVO musicVO : musicVOList) {
            if (musicVO.getCollectStatus()!=0){
                musicVO.setShow3(false);
            }
        }
        return musicVOList;
    }

    @RequestMapping("/time")
    @ResponseBody
    public List<MusicVO> musicInfoList2(@RequestBody Map<String, Object> info){

        String time= info.get("time").toString();

        List<Score> scoreList=scoreRepository.findAll();

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        List<MusicVO> musicVOList1 = collectionService.musiccollect(userId2);

        List<MusicInfo> musicInfoList=musicInfoRepository.queryLike2(time);

        List<MusicVO> musicVOList=new ArrayList<>();

        for (MusicInfo musicInfo:musicInfoList){
            MusicVO musicVO=new MusicVO();
            BeanUtils.copyProperties(musicInfo,musicVO);
            musicVOList.add(musicVO);
        }

        Integer index=-1;
        for (MusicVO musicVO:musicVOList){
            index++;
            for (Score score:scoreList){
                if (musicVO.getMusicId()==score.getMusicId()){
                    double score1=scoreService.score3(musicVO.getMusicId());
                    Integer number=scoreRepository.findByMusicId(musicVO.getMusicId()).size();
                    musicVOList.get(index).setScore(score1);
                    musicVOList.get(index).setNumber(number);
                }
            }
        }

        for (MusicVO musicVO : musicVOList) {
            for (MusicVO musicVO1 : musicVOList1) {
                if (musicVO.getMusicId() == musicVO1.getMusicId()) {
                    musicVO.setCollectStatus(musicVO1.getCollectStatus());
                }
            }
        }
        for (MusicVO musicVO : musicVOList) {
            if (musicVO.getCollectStatus()!=0){
                musicVO.setShow3(false);
            }
        }

        return  musicVOList;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public MusicVO musicDetail(@RequestBody Map<String, Object> info){

        String musicId= info.get("musicId").toString();

        Integer musicId2=Integer.parseInt(musicId);

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        List<Collection> collectionList=collectionService.collectAll();

        MusicInfo musicInfo=musicService.findOne(musicId2);

        MusicVO musicVO=new MusicVO();

        BeanUtils.copyProperties(musicInfo,musicVO);

        double score=scoreService.score3(musicId2);

        musicVO.setScore(score);

        for (Collection collection:collectionList){
            if (collection.getMusicId()==musicId2&&collection.getUserId()==userId2){
                musicVO.setCollectStatus(collection.getCollectionStatus());
            }
        }
        if(musicVO.getCollectStatus()!=0){
            musicVO.setShow3(false);
        }

        return musicVO;
    }

    @RequestMapping("/discuss")
    @ResponseBody
    public List<CommentVO> commentVOList(@RequestBody Map<String, Object> info){

        String musicId= info.get("musicId").toString();
        Integer musicId2=Integer.parseInt(musicId);

        List<CommentVO> commentVOList=commentService.musicAll2(musicId2);
        return commentVOList;
    }

    @RequestMapping("/collect")
    @ResponseBody
    public boolean collect(@RequestBody Map<String, Object> info){

        String musicId= info.get("musicId").toString();
        Integer musicId2=Integer.parseInt(musicId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String code= info.get("code").toString();
        Integer code2=Integer.parseInt(code);

        String comment= info.get("comment").toString();

        collectionService.musiccreate(userId2,code2,musicId2);

        commentService.musiccreate(userId2,musicId2,comment);

        return true;

    }

    @RequestMapping("/rate")
    @ResponseBody
    public RateVO rate(@RequestBody Map<String, Object> info){

        String musicId= info.get("musicId").toString();
        Integer musicId2=Integer.parseInt(musicId);

        RateVO rateVO=scoreService.scorelist3(musicId2);

        return rateVO;

    }

    @RequestMapping("/rateup")
    @ResponseBody
    public Boolean rateup(@RequestBody Map<String, Object> info){

        String musicId= info.get("musicId").toString();
        Integer musicId2=Integer.parseInt(musicId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String score= info.get("score").toString();
        double score2=Double.valueOf(score);

        Score score1=scoreService.musicscore(musicId2,userId2,score2);

        return true;

    }

    @RequestMapping("/delcollect")
    @ResponseBody
    public Boolean delcollect(@RequestBody Map<String, Object> info) {

        String musicId = info.get("musicId").toString();
        Integer musicId2 = Integer.parseInt(musicId);

        String userId = info.get("userId").toString();
        Integer userId2 = Integer.parseInt(userId);

        String code= info.get("code").toString();
        Integer code2=Integer.parseInt(code);

        collectionService.musiccreate(userId2,code2,musicId2);

        return true;
    }




}
