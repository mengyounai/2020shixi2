package com.example.demo.controller2;

import com.example.demo.VO.*;
import com.example.demo.service.AnimeService;
import com.example.demo.service.BookService;
import com.example.demo.service.MusicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
@Api(description = "查询信息相关操作接口")
@CrossOrigin
public class SearchController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MusicService musicService;

    @RequestMapping("/search")
    @ResponseBody
    public SearchSumVO SearchSumVO(@RequestBody Map<String, Object> info){

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String searchInfo=info.get("searchInfo").toString();

        SearchSumVO searchSumVO=new SearchSumVO();

        SearchVO searchVO=new SearchVO();

        List<AnimeVO> animeVOList=animeService.search(userId2,searchInfo);

        List<BookVO> bookVOList=bookService.search(userId2,searchInfo);

        List<MusicVO> musicVOList=musicService.search(userId2,searchInfo);

        searchVO.setAnimeVOList(animeVOList);

        searchVO.setBookVOList(bookVOList);

        searchVO.setMusicVOList(musicVOList);

        searchSumVO.setSearchVO(searchVO);

        return searchSumVO;
    }


}
