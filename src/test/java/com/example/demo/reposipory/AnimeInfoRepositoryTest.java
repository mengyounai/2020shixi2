package com.example.demo.reposipory;

import com.example.demo.dataobject.AnimeInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AnimeInfoRepositoryTest {

    @Autowired
    AnimeInfoRepository repository;

    @Test
    public void saveTest(){
        AnimeInfo animeInfo=new AnimeInfo();
        animeInfo.setAnimeId(20);
        animeInfo.setAnimeName("未来日记2");
        animeInfo.setAnimeIcon("weilairiji");
        animeInfo.setAnimeTime("2002-02-07");
        animeInfo.setAnimeAuthor("えすのサカエ");
        animeInfo.setLabelType(1);
        animeInfo.setAnimeDescription("天野雪辉是个优秀的学生，每天都以手机写日记。一天,天野雪辉从一个叫时空王「deus.x.makina」收到一部手机，而deus说这是个游戏，这样雪野就收下了。可是他后来发现这不是一部普通的手机，而是写著他的未来--「未来日记」……当他知道不久后，手机出现「18:21 dead end」的字句，正当他慌张不已时，另外一个未来日记的持有者出现了，奇怪的事从此就展开了……");
        animeInfo.setAnimeStatus(0);
        animeInfo.setAnimeCharacter("我妻由乃");

        AnimeInfo result=repository.save(animeInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByamimeStatus(){
        List<AnimeInfo> animeInfos=repository.findByAnimeStatus(0);
        Assert.assertNotNull("0",animeInfos.size());
    }

    @Test
    public void queryLike(){
        List<AnimeInfo> animeInfoList=repository.queryLike("记");
        for (AnimeInfo animeInfo:animeInfoList) {
            System.out.println(animeInfo);
        }
        assertNotEquals(1,animeInfoList.size());
    }

    @Test
    public void queryLike2(){
        List<AnimeInfo> animeInfoList=repository.queryLike2("2002");
        for (AnimeInfo animeInfo:animeInfoList) {
            System.out.println(animeInfo);
        }
        assertNotEquals(1,animeInfoList.size());
    }

}