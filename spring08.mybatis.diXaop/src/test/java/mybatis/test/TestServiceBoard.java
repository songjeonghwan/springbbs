package mybatis.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mybatis.model.*;
import mybatis.service.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    //private static SqlSession session = null;
    private static Logger logger = LoggerFactory.getLogger(TsetServiceUser.class);
    
    private static ApplicationContext context = null;
    private static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("boardservice", IServiceBoard.class);
        //SqlSessionFactory sqlMapper = MyBatisManager.getInstance();  

       // session = sqlMapper.openSession(); 
//
//        javax.sql.DataSource dataSource = sqlMapper.getConfiguration().getEnvironment().getDataSource();
//        java.sql.Connection conn = dataSource.getConnection();
//        java.sql.DatabaseMetaData prop = conn.getMetaData();
//        
//        String  driver   = "oracle.jdbc.OracleDriver";
//        String  url      = prop.getURL();
//        String  username = prop.getUserName();
//        String  password = "1234";
//
//        new SeedDataLoader(conn).loadIntegrationTestDataSeed();
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //session.close();
    }
    

//        File folder = new ClassPathResource("sql").getFile();
//        File[] listOfFiles = folder.listFiles();

          
    
    @Test
    public void getBoardName() {
        //IServiceBoard board = new ServiceBoard( session );        
        String result = service.getBoardName("free");
        assertEquals(result, "자유게시판");
    }

    @Test
    public void getBoardOne() {
        //IServiceBoard board = new ServiceBoard( session );        
        ModelBoard result = service.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
        assertEquals(result.getBoardcd(), "data"      );
        assertEquals(result.getUseYN()  , true        );
    }

    @Test
    public void getBoardTotalRecord() {
    }

    @Test
    public void getBoardList() {
        //IServiceBoard board = new ServiceBoard(session);        
        List<ModelBoard> result = service.getBoardList();
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getBoardcd(), "qna");
    }

    @Test
    public void getBoardListResultMap() {
        //IServiceBoard board = new ServiceBoard(session);        
        Map<String, ModelBoard> result = service.getBoardListResultMap();
        assertEquals(result.size(), 3);
        assertEquals(result.get("free").getBoardnm(), "자유게시판");
    }

    @Test
    public void insertBoard()  {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setBoardnm("공지사항");
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
        model.setUseYN(true);
        

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.insertBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void updateBoard() {
        ModelBoard updateBoard = new ModelBoard();
        updateBoard.setBoardcd("notice");
        updateBoard.setBoardnm("새로운 공지사항");
        updateBoard.setInsertDT(new Date());
        updateBoard.setInsertUID("insertUID");
        updateBoard.setUpdateDT(new Date());
        updateBoard.setUpdateUID("updateUID");
        updateBoard.setUseYN(true);
        
        ModelBoard searchBoard = new ModelBoard();
        searchBoard.setBoardcd("notice");

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.updateBoard(updateBoard, searchBoard);
        assertEquals(result, 1);
    }

    @Test
    public void deleteBoard() {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setUseYN(true);

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.deleteBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void getBoardSearch() {
        ModelBoard model = null;
        
        model = new ModelBoard();        
        model.setBoardcd("a");        
        //IServiceBoard board = new ServiceBoard(session);        
        List<ModelBoard> result = service.getBoardSearch(model);        
        assertEquals(result.size(), 2);
        
        model = new ModelBoard();
        model.setBoardnm("자료실");        
        //service = new ServiceBoard(session);        
        result = service.getBoardSearch(model);        
        assertEquals(result.size(), 1);
    }

    @Test
    public void getBoardPaging() {
    }

    @Test
    public void insertBoardList() {
        ModelBoard model = null;
        List<ModelBoard> list = new ArrayList<ModelBoard>();
        Date d = new Date();
        String current = new SimpleDateFormat("yyMMddHHmmss").format( d );
        
        for( int i=0; i<10; i=i+1){            
            model = new ModelBoard();
            model.setBoardcd("notice" + current + i );
            model.setBoardnm("공지사항" + current + i );
            model.setUseYN(true);     
            model.setInsertDT( d );
            model.setInsertUID("insertUID" + i);
            model.setUpdateDT( d );
            model.setUpdateUID("updateUID" + i);  
            
            list.add( model );
        }

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.insertBoardList(list);
        assertEquals(result, 1);
    }

    @Test
    public void getArticleTotalRecord() {
        //IServiceBoard board = new ServiceBoard(session);  
        String boardcd    = "free";  
        String searchWord = "article";
        int result = service.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(result, 14);
    }

    @Test
    public void getArticleList() {
        //IServiceBoard board = new ServiceBoard(session);  
        String boardcd    = "free";  
        String searchWord = "article";
        int    start = 2;
        int    end   = 7;
        List<ModelArticle> result = service.getArticleList(boardcd, searchWord, start, end);
        assertEquals(result.size(), 6);
    }

    @Test
    public void getArticle() {
        //IServiceBoard board = new ServiceBoard(session);   
        ModelArticle result = service.getArticle(1);
        assertEquals(result.getTitle(), "article test 01");
    }

    @Test
    public void insertArticle() {
        ModelArticle model = new ModelArticle();
        //model.setArticleno(articleno);
        model.setBoardcd("free");
        model.setContent("tesr yd cyt");
        model.setEmail("sjydevil@gamil.com");
        model.setHit(0);
        model.setRegdate( new Date() );
        model.setTitle("insert article test");
        model.setUseYN(true);
        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
        
        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.insertArticle(model);
        assertEquals(result, 1);
    }

    @Test
    public void updateArticle() {       
        
        ModelArticle updateValue = new ModelArticle(); 
        updateValue.setContent("tesr update cyt");
        updateValue.setTitle("update article test");
        updateValue.setUseYN(true);
        updateValue.setUpdateDT(new Date());
        updateValue.setUpdateUID("updateUID");
        
        ModelArticle searchValue = new ModelArticle();     
        searchValue.setBoardcd("free");
        searchValue.setContent("tesr update cyt");
        searchValue.setEmail("sjydevil@gamil.com");
        
        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.updateArticle(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void deleteArticle() {
        ModelArticle searchValue = new ModelArticle();     
        searchValue.setBoardcd("free");
        searchValue.setContent("tesr update cyt");
        searchValue.setEmail("sjydevil@gamil.com");
        
        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.deleteArticle(searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void increaseHit() {
        //IServiceBoard board = new ServiceBoard(session); 
        
        int articleNo  = 1;
        
        ModelArticle beforeArticle = service.getArticle(articleNo);        
        service.increaseHit(articleNo);        
        ModelArticle afterArticle = service.getArticle(articleNo);

        assertSame(beforeArticle.getHit()+2, afterArticle.getHit());
    }

    @Test
    public void getNextArticle() {
        //IServiceBoard board = new ServiceBoard(session); 
        ModelArticle result = service.getNextArticle(1, "free", "");
        assertSame(result.getArticleno(), 2);
    }

    @Test
    public void getPrevArticle() {
        
        //IServiceBoard board = new ServiceBoard(session); 
        ModelArticle result = service.getPrevArticle(2, "free", "");
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void getAttachFileList() {
        //IServiceBoard board = new ServiceBoard(session);  
        int articleNo    = 1;  
        List<ModelAttachfile> result = service.getAttachFileList(articleNo);
        assertEquals(result.size(), 7);
   
    }

    @Test
    public void getAttachFile() {
        //IServiceBoard board = new ServiceBoard(session); 
        ModelAttachfile result = service.getAttachFile(2);
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void insertAttachFile() {
        ModelAttachfile model = new ModelAttachfile();
        //model.setArticleno(articleno);
        model.setFilename("굿");
        model.setFiletype("굿");
        model.setFilesize(1);
        model.setArticleno(1);
        model.setInsertDT(new Date());
        model.setInsertUID("ajjj");
        model.setUpdateDT(new Date());
        model.setUpdateUID("sss");
        
     
        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.insertAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void deleteAttachFile() {
        
        ModelAttachfile model = new ModelAttachfile();
        model.setAttachfileno(8);

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.deleteAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void getCommentList() {
        //IServiceBoard board = new ServiceBoard(session);  
        int articleNo    = 1;  
        List<ModelComments> result = service.getCommentList(articleNo);
        assertEquals(result.size(), 1);
    }

    @Test
    public void getComment() {
        //IServiceBoard board = new ServiceBoard(session); 
        ModelComments result = service.getComment(1);
        assertSame(result.getCommentno(), 1);

    }

    @Test
    public void insertComment() {
        ModelComments model = new ModelComments();
        //model.setArticleno(articleno);
        model.setArticleno(1);
        model.setEmail("927902@naver.com");
        model.setMemo("메모");
        model.setRegdate(new Date());
        model.setInsertUID("111");
        model.setInsertDT(new Date());
        model.setUpdateUID("111");
        model.setUpdateDT(new Date());
        
        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.insertComment(model);
        assertEquals(result, 1);
    }

    @Test
    public void updateComment() {
        ModelComments updateBoard = new ModelComments();
        
        updateBoard.setEmail("927902@naver.com");
        updateBoard.setMemo("메모222222222");
        updateBoard.setUseYN(1);
        
        ModelComments searchBoard = new ModelComments();
        searchBoard.setCommentno(1);

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.updateComment(updateBoard, searchBoard);
        assertEquals(result, 1);
    }

    @Test
    public void deleteComment() {
        ModelComments model = new ModelComments();
        model.setCommentno(2);

        //IServiceBoard board = new ServiceBoard(session);        
        int result = service.deleteComment(model);
        assertEquals(result, 1);
    }
}
