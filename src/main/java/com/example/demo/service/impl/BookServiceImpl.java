package com.example.demo.service.impl;

import com.example.demo.VO.AnimeVO;
import com.example.demo.VO.BookVO;
import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.Label;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.BookInfoRepository;
import com.example.demo.reposipory.CollectionRepository;
import com.example.demo.reposipory.LabelRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookInfoRepository repository;

    @Autowired
    private BookService bookService;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public BookInfo findOne(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public List<BookVO> search(Integer userId,String bookName) {
        List<Collection> collectionList=collectionRepository.findAll();

        List<BookVO> bookVOList=new ArrayList<>();

        List<BookInfo> bookInfoList=repository.queryLike(bookName);

        for (BookInfo bookInfo:bookInfoList){
            BookVO bookVO=new BookVO();
            BeanUtils.copyProperties(bookInfo,bookVO);
            bookVOList.add(bookVO);
        }

        for (BookVO bookVO:bookVOList){
            for (Collection collection:collectionList){
                if (bookVO.getBookId()==collection.getAnimeId()&&userId==collection.getUserId()){
                    bookVO.setCollectStatus(collection.getCollectionStatus());
                }
            }
        }



        return bookVOList;
    }

    @Override
    public List<BookInfo> findOne2(Integer labelTypeList) {
        return repository.findByLabelType(labelTypeList);
    }

    @Override
    public List<BookInfo> findOne3(String labelName) {
        Label label=labelRepository.findByLabelName(labelName);
        List<BookInfo> bookInfoList=bookService.findOne2(label.getLabelType());
        return bookInfoList;
    }

    @Override
    public List<BookInfo> findOne4(String time) {
        return null;
    }

    @Override
    public List<String> labelAll() {
        List<BookInfo> upAll = bookService.findUpAll();

        boolean result=true;
        List<Integer> labelList=new ArrayList<>();
        for (BookInfo bookInfo:upAll){
            for (Integer temp:labelList) {
                if (bookInfo.getLabelType() == temp) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
            if (result) {
                labelList.add(bookInfo.getLabelType());
            }
        }
        List<String> labelAll=new ArrayList<>();
        for (Integer a:labelList){
            String label=labelRepository.findByLabelType(a).getLabelName();
            labelAll.add(label);
        }
        return labelAll;
    }

    @Override
    public List<Integer> timeAll() {
        List<BookInfo> upAll = bookService.findUpAll();

        List<Integer> timeAll=new ArrayList<>();
        for (BookInfo bookInfo:upAll){
            boolean a=true;
            String time=bookInfo.getBookTime().substring(0,4);

            int time2=Integer.parseInt(time);

            for (Integer time3:timeAll){
                if (time2==time3){
                    a=false;
                    break;
                }
            }
            if (a){
                timeAll.add(time2);
            }

        }
        return timeAll;
    }

    @Override
    public Page<BookInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<BookInfo> findUpAll() {
        return repository.findByBookStatus(1);
    }

    @Override
    public Page<BookInfo> findUpAll(Pageable pageable) {
        Page<BookInfo> bookInfoPage=repository.findByBookStatus(0,pageable);
        return bookInfoPage;
    }

    @Override
    public BookInfo save(BookInfo bookInfo) {
        return repository.save(bookInfo);
    }

    @Override
    public BookInfo Up(Integer bookId) {
        BookInfo bookInfo=repository.findById(bookId).orElse(null);
        if (bookInfo.getBookStatus()==0){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        bookInfo.setBookStatus(0);
        return repository.save(bookInfo);
    }

    @Override
    public BookInfo down(Integer bookId) {
        BookInfo bookInfo=repository.findById(bookId).orElse(null);
        if (bookInfo.getBookStatus()==1){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        bookInfo.setBookStatus(1);
        return repository.save(bookInfo);
}
}
