package com.example.demo.VO;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.MusicInfo;
import lombok.Data;

import java.util.List;

@Data
public class IndexVO {

    List<AnimeVO> animeInfoList1;

    List<BookVO> bookInfoList1;

    List<MusicVO> musicInfoList1;

    List<AnimeVO> animeInfoList2;

    List<BookVO> bookInfoList2;

    List<MusicVO> musicInfoList2;

    List<PeopleVO> peopleVOList;
}
