package com.example.demo.reposipory;

import com.example.demo.dataobject.MusicInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicInfoRespository extends JpaRepository<MusicInfo,Integer> {

    public List<MusicInfo> findByMusicStatus(Integer musicStatus);

    public Page<MusicInfo> findByMusicStatus(Integer musicStatus, Pageable pageable);


    //根据动画id查询音乐
    List<MusicInfo> findByMusicId(String musicId);

    //根据动画类型查询动画
    public List<MusicInfo> findByLabelType(Integer labelTypeList);

    //根据动画出版时间查询动画
    public List<MusicInfo> findByMusicTime(String time);

    @Query("select p from MusicInfo p where p.musicName like %:name%")
    public List<MusicInfo> queryLike(@Param("name") String name);

    @Query("select p from MusicInfo p where p.musicTime like %:name%")
    public List<MusicInfo> queryLike2(@Param("name") String name);


}
