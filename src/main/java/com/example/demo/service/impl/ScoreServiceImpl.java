package com.example.demo.service.impl;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.RateVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.MusicInfo;
import com.example.demo.dataobject.Score;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.ScoreRepository;
import com.example.demo.service.AnimeService;
import com.example.demo.service.ScoreService;
import com.example.demo.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository repository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private AnimeService animeService;

    String scoreId= KeyUtil.genUniquKey();

    @Override
    public AnimeInfo findByAnimeId(Integer animeId) {
        return null;
    }

    @Override
    public RateVO scorelist(Integer animeId) {

        RateVO rateVO=new RateVO();

        List<Score> scoreList=repository.findByAnimeId(animeId);

        Integer sum1=0;
        Integer sum2=0;
        Integer sum3=0;
        Integer sum4=0;
        Integer sum5=0;
        for (Score score:scoreList){
            if (score.getScore()==0.5||score.getScore()==1){
                sum1++;
                rateVO.setCount1(sum1);
            }else if (score.getScore()==1.5||score.getScore()==2){
                sum2++;
                rateVO.setCount2(sum2);
            }
            else if (score.getScore()==2.5||score.getScore()==3){
                sum3++;
                rateVO.setCount3(sum3);
            }else if (score.getScore()==3.5||score.getScore()==4){
                sum4++;
                rateVO.setCount4(sum4);
            }else {
                sum5++;
                rateVO.setCount5(sum5);
            }
        }
        return rateVO;
    }

    @Override
    public Score animescore(Integer animeId,Integer userId,double score) {

        Score score1=new Score();

        List<Score> scoreList=repository.findByAnimeId(animeId);

        boolean a=true;

        for (Score score2:scoreList){
            if (userId==score2.getUserId()&&animeId==score2.getAnimeId()){
                a=false;
                score1=score2;
                score1.setScore(score);

            }
        }
        if (a){
            score1.setScoreId(scoreId);
            score1.setUserId(userId);
            score1.setAnimeId(animeId);
            score1.setScore(score);
        }

        repository.save(score1);

        return score1;
    }

    @Override
    public BookInfo findByBookId(Integer bookId) {
        return null;
    }

    @Override
    public MusicInfo findByMusicId(Integer musicId) {
        return null;
    }

    @Override
    public double score(Integer animeId) {
        List<Score> scoreList=repository.findByAnimeId(animeId);

        int sum=0;
        for (Score score:scoreList){
            sum+=score.getScore();
        }
        double result=0;

//        double s=Double.valueOf(result).intValue();
        DecimalFormat df = new DecimalFormat("#.00");
        result = (float)sum/scoreList.size() ;
        result = (double) Math.round(result * 10) / 10;
        return result;
    }

    @Override
    public double score2(Integer bookId) {
        List<Score> scoreList=repository.findByBookId(bookId);

        int sum=0;
        for (Score score:scoreList){
            sum+=score.getScore();
        }
        double result=0;

//        double s=Double.valueOf(result).intValue();
        DecimalFormat df = new DecimalFormat("#.00");
        result = (float)sum/scoreList.size() ;
        result = (double) Math.round(result * 10) / 10;
        return result;
    }

    @Override
    public double score3(Integer musicId) {
        List<Score> scoreList=repository.findByMusicId(musicId);

        int sum=0;
        for (Score score:scoreList){
            sum+=score.getScore();
        }
        double result=0;

//        double s=Double.valueOf(result).intValue();
        DecimalFormat df = new DecimalFormat("#.00");
        result = (float)sum/scoreList.size() ;
        result = (double) Math.round(result * 10) / 10;
        return result;
    }

    @Override
    public List<Double> scoresum() {

        List<Score> scoreList=repository.findAll();

        List<AnimeInfo> animeInfoList=animeService.findUpAll();

        List<Score> scoresum=new ArrayList<>();

        List<Double> scoreList1=new ArrayList<>();
        for (AnimeInfo animeInfo:animeInfoList) {
            for (Score score:scoreList){
                if (animeInfo.getAnimeId()==score.getAnimeId()){
                    double score1=scoreService.score(animeInfo.getAnimeId());
                    scoreList1.add(score1);
                    break;
                }
            }
        }

        return scoreList1;
    }

    @Override
    public List<Score> findAnimeAll(Integer animeId) {
        return repository.findByAnimeId(animeId);
    }

    @Override
    public Page<Score> findBookAll(Integer bookId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Score> findMusicAll(Integer musicId, Pageable pageable) {
        return null;
    }


}

