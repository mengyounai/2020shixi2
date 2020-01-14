package com.example.demo.controller2;


import com.example.demo.VO.*;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.service.CollectionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
@Api(description = "主页信息相关操作接口")
@CrossOrigin
public class IndexController {

    @Autowired
    private CollectionService collectionService;


    @RequestMapping("/collectAll")
    @ResponseBody
    public IndexVO collectAll(@RequestBody Map<String, Object> info){

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        List<AnimeVO> animeInfoList=collectionService.animecollect(userId2);

        List<AnimeVO> animeInfoList2=new ArrayList<>();

        List<AnimeVO> animeInfoList3=new ArrayList<>();

        List<BookVO> bookInfoList=collectionService.bookcollect(userId2);

        List<BookVO> bookInfoList2=new ArrayList<>();

        List<BookVO> bookInfoList3=new ArrayList<>();

        List<MusicVO> musicInfoList=collectionService.musiccollect(userId2);

        List<MusicVO> musicInfoList2=new ArrayList<>();

        List<MusicVO> musicInfoList3=new ArrayList<>();

        List<PeopleVO> peopleInfoList=collectionService.peoplecollect(userId2);

        List<PeopleVO> peopleInfoList2=new ArrayList<>();

        IndexVO indexVO=new IndexVO();

        for (AnimeVO animeVO:animeInfoList){
            if (animeVO.getCollectStatus()==1){
                AnimeVO animeVO1=new AnimeVO();
                animeVO1=animeVO;
                animeInfoList2.add(animeVO1);
            }else if (animeVO.getCollectStatus()==2){
                AnimeVO animeVO2=new AnimeVO();
                animeVO2=animeVO;
                animeInfoList3.add(animeVO2);
            }
        }

        for (BookVO bookVO:bookInfoList){
            if (bookVO.getCollectStatus()==1){
                BookVO bookVO1=new BookVO();
                bookVO1=bookVO;
                bookInfoList2.add(bookVO1);
            }else if (bookVO.getCollectStatus()==2){
                BookVO bookVO2=new BookVO();
                bookVO2=bookVO;
                bookInfoList3.add(bookVO2);
            }
        }

        for (MusicVO musicVO:musicInfoList){
            if (musicVO.getCollectStatus()==1){
                MusicVO musicVO1=new MusicVO();
                musicVO1=musicVO;
                musicInfoList2.add(musicVO1);
            }else if (musicVO.getCollectStatus()==2){
                MusicVO musicVO2=new MusicVO();
                musicVO2=musicVO;
                musicInfoList3.add(musicVO2);
            }
        }

        for (PeopleVO peopleVO:peopleInfoList){
            if (peopleVO.getCollectStatus()==1){
                PeopleVO peopleVO1=new PeopleVO();
                peopleVO1=peopleVO;
                peopleInfoList2.add(peopleVO1);
            }
        }

        indexVO.setAnimeInfoList1(animeInfoList2);

        indexVO.setAnimeInfoList2(animeInfoList3);

        indexVO.setBookInfoList1(bookInfoList2);

        indexVO.setBookInfoList2(bookInfoList3);

        indexVO.setMusicInfoList1(musicInfoList2);

        indexVO.setMusicInfoList2(musicInfoList3);

        indexVO.setPeopleVOList(peopleInfoList2);



        return indexVO;
    }

}
