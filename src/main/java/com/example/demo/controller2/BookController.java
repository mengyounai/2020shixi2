package com.example.demo.controller2;

import com.example.demo.VO.BookVO;
import com.example.demo.VO.CommentVO;
import com.example.demo.VO.RateVO;
import com.example.demo.dataobject.BookInfo;
import com.example.demo.dataobject.Score;
import com.example.demo.reposipory.BookInfoRepository;
import com.example.demo.reposipory.ScoreRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.CommentService;
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
@RequestMapping("/book")
@Api(description = "书籍信息相关操作接口")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookInfoRepository bookInfoRepository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public List<BookVO> list(){

        //1.查询所有上架动漫
        List<BookInfo> bookInfoList=bookService.findUpAll();

        List<BookVO> bookVOList=new ArrayList<>();

        List<Score> scoreList=scoreRepository.findAll();

        List<Score> scoresum=new ArrayList<>();
        for (BookInfo bookInfo:bookInfoList){
            BookVO bookVO=new BookVO();
            BeanUtils.copyProperties(bookInfo,bookVO);
            bookVOList.add(bookVO);
        }
        Integer index=-1;
        for (BookVO bookVO:bookVOList){
            index++;
            for (Score score:scoreList){
                if (bookVO.getBookId()==score.getBookId()){
                    double score1=scoreService.score2(bookVO.getBookId());
                    Integer number=scoreRepository.findByBookId(bookVO.getBookId()).size();
                    bookVOList.get(index).setScore(score1);
                    bookVOList.get(index).setNumber(number);
                }
            }
        }

        return bookVOList;
    }

    @GetMapping("type")
    public List<String> labelAll(){

        List<String> labelAll=bookService.labelAll();
        return labelAll;
    }

    @GetMapping("time")
    public List<Integer> timeAll(){

        List<Integer> timeAll=bookService.timeAll();
        Collections.sort(timeAll);
        return timeAll;
    }

    @RequestMapping("/type")
    @ResponseBody
    public List<BookVO> bookInfoList(@RequestBody Map<String, Object> info){

        String bookName= info.get("bookName").toString();

        List<Score> scoreList=scoreRepository.findAll();

        List<BookInfo> bookInfoList=bookService.findOne3(bookName);
        List<BookVO> bookVOList=new ArrayList<>();

        for (BookInfo bookInfo:bookInfoList){
            BookVO bookVO=new BookVO();
            BeanUtils.copyProperties(bookInfo,bookVO);
            bookVOList.add(bookVO);
        }

        Integer index=-1;
        for (BookVO bookVO:bookVOList){
            index++;
            for (Score score:scoreList){
                if (bookVO.getBookId()==score.getBookId()){
                    double score1=scoreService.score2(bookVO.getBookId());
                    Integer number=scoreRepository.findByBookId(bookVO.getBookId()).size();
                    bookVOList.get(index).setScore(score1);
                    bookVOList.get(index).setNumber(number);
                }
            }
        }
        return bookVOList;
    }

    @RequestMapping("/time")
    @ResponseBody
    public List<BookVO> bookInfoList2(@RequestBody Map<String, Object> info){

        String time= info.get("time").toString();

        List<Score> scoreList=scoreRepository.findAll();

        List<BookInfo> bookInfoList=bookInfoRepository.queryLike2(time);

        List<BookVO> bookVOList=new ArrayList<>();

        for (BookInfo bookInfo:bookInfoList){
            BookVO bookVO=new BookVO();
            BeanUtils.copyProperties(bookInfo,bookVO);
            bookVOList.add(bookVO);
        }

        Integer index=-1;
        for (BookVO bookVO:bookVOList){
            index++;
            for (Score score:scoreList){
                if (bookVO.getBookId()==score.getBookId()){
                    double score1=scoreService.score2(bookVO.getBookId());
                    Integer number=scoreRepository.findByBookId(bookVO.getBookId()).size();
                    bookVOList.get(index).setScore(score1);
                    bookVOList.get(index).setNumber(number);
                }
            }
        }

        return  bookVOList;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public BookVO bookDetail(@RequestBody Map<String, Object> info){

        String bookId= info.get("bookId").toString();

        Integer bookId2=Integer.parseInt(bookId);

        BookInfo bookInfo=bookService.findOne(bookId2);

        BookVO bookVO=new BookVO();

        BeanUtils.copyProperties(bookInfo,bookVO);

        return bookVO;
    }

    @RequestMapping("/discuss")
    @ResponseBody
    public List<CommentVO> commentVOList(@RequestBody Map<String, Object> info){

        String bookId= info.get("bookId").toString();
        Integer bookId2=Integer.parseInt(bookId);

        List<CommentVO> commentVOList=commentService.bookAll2(bookId2);
        return commentVOList;
    }

    @RequestMapping("/collect")
    @ResponseBody
    public boolean collect(@RequestBody Map<String, Object> info){

        String bookId= info.get("bookId").toString();
        Integer bookId2=Integer.parseInt(bookId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String code= info.get("code").toString();
        Integer code2=Integer.parseInt(code);

        String comment= info.get("comment").toString();

        collectionService.bookcreate(userId2,code2,bookId2);

        commentService.bookcreate(userId2,bookId2,comment);

        return true;

    }

    @RequestMapping("/rate")
    @ResponseBody
    public RateVO rate(@RequestBody Map<String, Object> info){

        String bookId= info.get("bookId").toString();
        Integer bookId2=Integer.parseInt(bookId);

        RateVO rateVO=scoreService.scorelist2(bookId2);

        return rateVO;

    }

    @RequestMapping("/rateup")
    @ResponseBody
    public Boolean rateup(@RequestBody Map<String, Object> info){

        String bookId= info.get("bookId").toString();
        Integer bookId2=Integer.parseInt(bookId);

        String userId= info.get("userId").toString();
        Integer userId2=Integer.parseInt(userId);

        String score= info.get("score").toString();
        double score2=Double.valueOf(score);

        Score score1=scoreService.bookscore(bookId2,userId2,score2);

        return true;

    }


}
