package com.example.demo.VO;

import lombok.Data;

import java.util.List;

@Data
public class SearchVO {


    List<AnimeVO> animeVOList;

    List<BookVO> bookVOList;

    List<MusicVO> musicVOList;


}
