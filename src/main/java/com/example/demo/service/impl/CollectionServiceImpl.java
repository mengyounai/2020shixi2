package com.example.demo.service.impl;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.BookVO;
import com.example.demo.VO.MusicVO;
import com.example.demo.conveter.Collection2CollectionDTOConveter;
import com.example.demo.dataobject.*;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.CollectEnum;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.AnimeInfoRepository;
import com.example.demo.reposipory.BookInfoRepository;
import com.example.demo.reposipory.CollectionRepository;
import com.example.demo.reposipory.DetailRepository;
import com.example.demo.service.AnimeService;
import com.example.demo.service.BookService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.MusicService;
import com.example.demo.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private AnimeInfoRepository animeInfoRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private AnimeService animeService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MusicService musicService;

    @Autowired
    private BookInfoRepository bookInfoRepository;


    String collectionId = KeyUtil.genUniquKey();

    @Override
    public List<Collection> collectAll() {
        return collectionRepository.findAll();
    }

    @Override
    public CollectionDTO create(CollectionDTO collectionDTO) {


        for (Detail detail : collectionDTO.getDetailList()) {
            AnimeInfo animeInfo = animeInfoRepository.getOne(detail.getAnimeId());
            if (animeInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //收藏详情入库
            BeanUtils.copyProperties(animeInfo, detail);
            detail.setCollectionId(collectionId);
            detail.setDetailId(KeyUtil.genUniquKey());

            detailRepository.save(detail);
        }


        //将收藏信息入库
        Collection collection = new Collection();
        BeanUtils.copyProperties(collectionDTO, collection);
//        if (!collection.getCollectionId().isEmpty()){
//            collection.setCollectionId(collection.getCollectionId());
//        }else {
//            collection.setCollectionId(collectionId);
//        }
        collection.setCollectionId(collectionId);
        collection.setCollectionStatus(CollectEnum.FINISH.getCode());

        collectionRepository.save(collection);

        return collectionDTO;

    }

    @Override
    public CollectionDTO create2(CollectionDTO collectionDTO) {
        for (Detail detail : collectionDTO.getDetailList()) {
            BookInfo bookInfo = bookInfoRepository.getOne(detail.getBookId());
            if (bookInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //收藏详情入库
            BeanUtils.copyProperties(bookInfo, detail);
            detail.setCollectionId(collectionId);
            detail.setDetailId(KeyUtil.genUniquKey());

            detailRepository.save(detail);
        }


        //将收藏信息入库
        Collection collection = new Collection();
        BeanUtils.copyProperties(collectionDTO, collection);
//        if (!collection.getCollectionId().isEmpty()){
//            collection.setCollectionId(collection.getCollectionId());
//        }else {
//            collection.setCollectionId(collectionId);
//        }
        collection.setCollectionId(collectionId);
        collection.setCollectionStatus(CollectEnum.FINISH.getCode());

        collectionRepository.save(collection);

        return collectionDTO;

    }

    @Override
    public CollectionDTO create3(CollectionDTO collectionDTO) {
        return null;
    }

    @Override
    public Collection animecreate(Integer userId, Integer code, Integer animeId) {

        List<Collection> collectionList = collectionRepository.findAll();

        List<Collection> animecollectList = new ArrayList<>();

        Collection collection = new Collection();

        for (Collection collection1 : collectionList) {
            if (collection1.getAnimeId() != null) {
                animecollectList.add(collection1);
            }
        }

        boolean a = true;

        for (Collection collection1 : animecollectList) {
            if (collection1.getUserId() == userId && collection1.getAnimeId() == animeId) {
                a = false;
                collection = collection1;
                collection.setCollectionStatus(code);
            }
        }

        if (a) {
            collection.setUserId(userId);
            collection.setAnimeId(animeId);
            collection.setCollectionStatus(code);
            collection.setCollectionId(collectionId);
        }

        collectionRepository.save(collection);

        return collection;

    }

    @Override
    public Collection bookcreate(Integer userId, Integer code, Integer bookId) {
        List<Collection> collectionList = collectionRepository.findAll();

        List<Collection> bookcollectList = new ArrayList<>();

        for (Collection collection1 : collectionList) {
            if (collection1.getBookId() != null) {
                bookcollectList.add(collection1);
            }
        }

        boolean a = true;

        if (bookcollectList.size() == 0) {

        } else {
            for (Collection collection1 : bookcollectList) {
                if (collection1.getUserId() == userId && collection1.getBookId() == bookId) {
                    a = false;
                    if (collection1.getCollectionStatus() != code) {
                        collection1.setCollectionStatus(code);
                        collectionRepository.save(collection1);
                        return collection1;

                    } else {
                        return null;
                    }
                }
            }
        }


        if (a) {
            Collection collection = new Collection();
            collection.setUserId(userId);
            collection.setBookId(bookId);
            collection.setCollectionStatus(code);
            collection.setCollectionId(collectionId);
            collectionRepository.save(collection);
            return collection;
        }


        return null;
    }

    @Override
    public Collection musiccreate(Integer userId, Integer code, Integer musicId) {
        List<Collection> collectionList = collectionRepository.findAll();

        boolean a = true;

        for (Collection collection1 : collectionList) {
            if (collection1.getUserId() == userId && collection1.getMusicId() == musicId) {
                a = false;
                if (collection1.getCollectionStatus() != code) {
                    collection1.setCollectionStatus(code);
                    collectionRepository.save(collection1);
                    return collection1;

                } else {
                    return null;
                }
            }
        }

        if (a) {
            Collection collection = new Collection();
            collection.setUserId(userId);
            collection.setMusicId(musicId);
            collection.setCollectionStatus(code);
            collection.setCollectionId(collectionId);
            collectionRepository.save(collection);
            return collection;
        }


        return null;
    }

    @Override
    public Collection peoplecreate(Integer userId,Integer code, Integer peopleId) {
        List<Collection> collectionList = collectionRepository.findAll();

        List<Collection> peoplecollectList = new ArrayList<>();

        Collection collection = new Collection();

        for (Collection collection1 : collectionList) {
            if (collection1.getPeopleId() != null) {
                peoplecollectList.add(collection1);
            }
        }

        boolean a = true;

        for (Collection collection1 : peoplecollectList) {
            if (collection1.getUserId() == userId && collection1.getPeopleId() == peopleId) {
                a = false;
                collection = collection1;
                collection.setCollectionStatus(code);
            }
        }

        if (a) {
            collection.setUserId(userId);
            collection.setPeopleId(peopleId);
            collection.setCollectionStatus(code);
            collection.setCollectionId(collectionId);
        }

        collectionRepository.save(collection);

        return collection;
    }

    @Override
    public Page<CollectionDTO> findAll(Integer userId, Pageable pageable) {


        Page<Collection> collectionPage = collectionRepository.findByUserId(userId, pageable);

        List<CollectionDTO> collectionDTOList = Collection2CollectionDTOConveter.convert(collectionPage.getContent());

        return new PageImpl<CollectionDTO>(collectionDTOList, pageable, collectionPage.getTotalElements());


    }

    @Override
    public CollectionDTO f(String collectionId) {

        //根据collectionId，从Collection表中查询数据
        Collection collection = collectionRepository.findById(collectionId).orElse(null);
        if (collection == null) {
            throw new SellException(ResultEnum.COLLECTION_NOT_EXIST);
        }

        //根据收藏编号查询它的所有详情
        List<Detail> detailList = detailRepository.findByCollectionId(collectionId);
        if (CollectionUtils.isEmpty(detailList)) {
            throw new SellException(ResultEnum.COLLECTIONDETAIL_NOT_EXIST);
        }

        //数据拼装并返回
        CollectionDTO collectionDTO = new CollectionDTO();
        BeanUtils.copyProperties(collection, collectionDTO);
        collectionDTO.setDetailList(detailList);

        return collectionDTO;


    }

    @Override
    public Page<CollectionDTO> findAnimeAll(Integer userId, Pageable pageable) {

        Page<Collection> collectionPage = collectionRepository.findByUserId(userId, pageable);

        List<CollectionDTO> collectionDTOList = Collection2CollectionDTOConveter.convert(collectionPage.getContent());

        List<CollectionDTO> collectionDTOList1 = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOList) {
            if (collectionDTO.getAnimeId() != null) {
                collectionDTOList1.add(collectionService.f(collectionDTO.getCollectionId()));
            }
        }
        return new PageImpl<CollectionDTO>(collectionDTOList1, pageable, collectionDTOList1.size());
    }

    @Override
    public Page<CollectionDTO> findBookAll(Integer userId, Pageable pageable) {
        Page<Collection> collectionPage = collectionRepository.findByUserId(userId, pageable);

        List<CollectionDTO> collectionDTOList = Collection2CollectionDTOConveter.convert(collectionPage.getContent());

        List<CollectionDTO> collectionDTOList1 = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOList) {
            if (collectionDTO.getBookId() != null) {
                collectionDTOList1.add(collectionService.f(collectionDTO.getCollectionId()));
            }
        }
        return new PageImpl<CollectionDTO>(collectionDTOList1, pageable, collectionDTOList1.size());
    }

    @Override
    public Page<CollectionDTO> findMusicAll(Integer userId, Pageable pageable) {
        Page<Collection> collectionPage = collectionRepository.findByUserId(userId, pageable);

        List<CollectionDTO> collectionDTOList = Collection2CollectionDTOConveter.convert(collectionPage.getContent());

        List<CollectionDTO> collectionDTOList1 = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOList) {
            if (collectionDTO.getMusicId() != null) {
                collectionDTOList1.add(collectionService.f(collectionDTO.getCollectionId()));
            }
        }
        return new PageImpl<CollectionDTO>(collectionDTOList1, pageable, collectionDTOList1.size());
    }

    @Override
    public Page<CollectionDTO> findPeopleAll(Integer userId, Pageable pageable) {
        return null;
    }

    @Override
    public CollectionDTO cancel(CollectionDTO collectionDTO) {

        //判断收藏状态
        if (!collectionDTO.getCollectionStatus().equals(CollectEnum.FINISH.getCode())) {
            log.error("[取消收藏]收藏状态不正确,收藏ID={},收藏状态={}", collectionDTO.getCollectionId(), collectionDTO.getCollectionStatus());
            throw new SellException(ResultEnum.COLLECTION_STATUS_ERROR);
        }

        //修改收藏状态
        Collection collection = new Collection();

        collectionDTO.setCollectionStatus(CollectEnum.New.getCode());
        BeanUtils.copyProperties(collectionDTO, collection);

        Collection updateResult = collectionRepository.save(collection);

        if (updateResult == null) {
            log.error("[取消收藏] 取消收藏失败,收藏={}", collection);
            throw new SellException(ResultEnum.COLLECTION_UPDATE_ERROR);
        }

        return collectionDTO;
    }

    @Override
    public Page<CollectionDTO> findList(Pageable pageable) {

        Page<Collection> collectionPage = collectionRepository.findAll(pageable);

        List<CollectionDTO> collectionDTOList = Collection2CollectionDTOConveter.convert(collectionPage.getContent());

        Page<CollectionDTO> collectionDTOPage = new PageImpl<CollectionDTO>(collectionDTOList, pageable, collectionPage.getTotalElements());

        return collectionDTOPage;
    }

    @Override
    public List<AnimeInfo> findByuserId(Integer userid, Pageable Pageable) {

        Page<CollectionDTO> collectionDTOPage = collectionService.findAll(userid, Pageable);

        if (collectionDTOPage == null) {
            log.error("[收藏为空] 查询收藏失败,收藏={}", collectionDTOPage);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        List<AnimeInfo> animeInfoList = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOPage) {
            if (collectionDTO.getAnimeId() != null) {
                AnimeInfo animeInfo = animeService.findOne(collectionDTO.getAnimeId());

                animeInfoList.add(animeInfo);
            }
        }
        if (animeInfoList == null) {
            log.error("[动画列表为空] 查询失败,animeInfoList={}", animeInfoList);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        return animeInfoList;
    }

    @Override
    public List<BookInfo> findByuserId2(Integer userid, Pageable Pageable) {
        Page<CollectionDTO> collectionDTOPage = collectionService.findAll(userid, Pageable);

        if (collectionDTOPage == null) {
            log.error("[收藏为空] 查询收藏失败,收藏={}", collectionDTOPage);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        List<BookInfo> bookInfoList = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOPage) {
            if (collectionDTO.getBookId() != null) {
                BookInfo bookInfo = bookService.findOne(collectionDTO.getBookId());

                bookInfoList.add(bookInfo);
            }
        }
        if (bookInfoList == null) {
            log.error("[动画列表为空] 查询失败,bookInfoList={}", bookInfoList);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        return bookInfoList;
    }

    @Override
    public List<MusicInfo> findByuserId3(Integer userid, Pageable Pageable) {
        Page<CollectionDTO> collectionDTOPage = collectionService.findAll(userid, Pageable);

        if (collectionDTOPage == null) {
            log.error("[收藏为空] 查询收藏失败,收藏={}", collectionDTOPage);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        List<MusicInfo> musicInfoList = new ArrayList<>();
        for (CollectionDTO collectionDTO : collectionDTOPage) {
            if (collectionDTO.getMusicId() != null) {
                MusicInfo musicInfo = musicService.findOne(collectionDTO.getMusicId());

                musicInfoList.add(musicInfo);
            }
        }
        if (musicInfoList == null) {
            log.error("[动画列表为空] 查询失败,musicInfoList={}", musicInfoList);
            throw new SellException(ResultEnum.COLLECTION_INFO_EMPTY);
        }

        return musicInfoList;
    }

    @Override
    public List<PeopleInfo> findByuserId4(Integer userid, Pageable Pageable) {
        return null;
    }

    @Override
    public List<AnimeVO> animecollect(Integer userId) {

        List<Collection> collectionList = collectionRepository.findByUserId(userId);

        List<AnimeVO> animeVOList=new ArrayList<>();

        for (Collection collection : collectionList) {
            if (collection.getAnimeId() != null) {
                AnimeVO animeVO=new AnimeVO();
                AnimeInfo animeInfo = animeService.findOne(collection.getAnimeId());
                BeanUtils.copyProperties(animeInfo,animeVO);
                animeVO.setCollectStatus(collection.getCollectionStatus());
                animeVOList.add(animeVO);
            }
        }

        return animeVOList;
    }

    @Override
    public List<BookVO> bookcollect(Integer userId) {
        List<Collection> collectionList = collectionRepository.findByUserId(userId);

        List<BookVO> bookVOList=new ArrayList<>();

        for (Collection collection : collectionList) {
            if (collection.getBookId() != null) {
                BookVO bookVO=new BookVO();
                BookInfo bookInfo = bookService.findOne(collection.getBookId());
                BeanUtils.copyProperties(bookInfo,bookVO);
                bookVO.setCollectStatus(collection.getCollectionStatus());
                bookVOList.add(bookVO);

            }
        }

        return bookVOList;
    }

    @Override
    public List<MusicVO> musiccollect(Integer userId) {
        List<Collection> collectionList = collectionRepository.findByUserId(userId);

        List<MusicVO> musicVOList=new ArrayList<>();

        for (Collection collection : collectionList) {
            if (collection.getMusicId() != null) {
                MusicVO musicVO=new MusicVO();
                MusicInfo musicInfo = musicService.findOne(collection.getMusicId());
                BeanUtils.copyProperties(musicInfo,musicVO);
                musicVO.setCollectStatus(collection.getCollectionStatus());
                musicVOList.add(musicVO);

            }
        }

        return musicVOList;
    }


}
