package mybatis.service;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.*;
import mybatis.model.*;

@Service("boardservice")
public class ServiceBoard implements IServiceBoard {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    //public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();    
    
    @Autowired
    @Qualifier("boardDao")
    //private SqlSession session;
    private IDaoBoard dao;
    
       
    public ServiceBoard() {
        super();
    }

    public ServiceBoard(IDaoBoard dao) {
        super();
        this.dao = dao;
    }

   
  

    @Override
    public String getBoardName(String boardcd) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        String result = null;
        try {
            result = dao.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName" + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        ModelBoard result = null;
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
        }
       
        
        return result;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
        }
    
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        Map<String, ModelBoard> result = null;
        try {
            result = dao.getBoardListResultMap();
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
        }
     
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.insertBoard(board);

            //session.commit();
        } catch (Exception e) {
            logger.error("insertBoard" + e.getMessage() );
            //session.rollback();
        }
     
        return result;
    }

    @Override
    public int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.updateBoard(updateBoard, searchBoard);
            //session.commit();
        } catch (Exception e) {
            logger.error("updateBoard" + e.getMessage() );
            //session.rollback();
        }
       
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.deleteBoard(board);
            //session.commit();
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage());
            //session.rollback();
        } 
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardSearch(board);
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.insertBoardList(list);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertBoardList" + e.getMessage() );
            //session.rollback();
        }
          
        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = 0;
        try {
            result = dao.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            logger.error("getArticleTotalRecord " + e.getMessage() );
        }
      
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord, int start, int end) {

        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(boardCd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getArticleList " + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        ModelArticle result = null;
        try {
                     dao.increaseHit( articleNo );
            result = dao.getArticle ( articleNo );
        } catch (Exception e) {
            logger.error("getArticle " + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.insertArticle(article);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertArticle " + e.getMessage() );
            //session.rollback();
        }
        finally {
            ////session.close();
        }        
        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {

        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.updateArticle(updateValue, searchValue);
            //session.commit();
        } catch (Exception e) {
            logger.error("updateArticle " + e.getMessage() );
            //session.rollback();
        }
        finally {
            ////session.close();
        }        
        
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.deleteArticle(article);
            //session.commit();
        } catch (Exception e) {
            logger.error("deleteArticle  " + e.getMessage() );
            //session.rollback();
        }
        finally {
            ////session.close();
        }        
        
        return result;
    }

    @Override
    public int increaseHit(int articleNo) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.increaseHit(articleNo);
            //session.commit();
        } catch (Exception e) {
            logger.error("increaseHit  " + e.getMessage() );
            //session.rollback();
        }
        finally {
            //session.close();
        }        
        
        return result;
    }

    @Override
    public ModelArticle getNextArticle(int articleNo, String boardCd,
            String searchWord) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd"    , boardCd);
        map.put("articleNo"  , articleNo);
        map.put("searchWord" , searchWord);
        
        ModelArticle result = null;
        try {
                     
            result = dao.getNextArticle ( map );
        } catch (Exception e) {
            logger.error("getNextArticle " + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(int articleNo, String boardCd,
            String searchWord) {
        //SqlSession session = sqlMapper.openSession();
          //IDaoBoard dao = new DaoBoard(session);
          
          Map<String, Object> map = new HashMap<String, Object>();
          map.put("boardCd"    , boardCd);
          map.put("articleNo"  , articleNo);
          map.put("searchWord" , searchWord);
          
          ModelArticle result = null;
          try {
                       
              result = dao.getPrevArticle ( map );
          } catch (Exception e) {
              logger.error("getPrevArticle " + e.getMessage() );
          }
          finally {
              //session.close();            
          }
          
          return result;
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
            //IDaoBoard dao = new DaoBoard(session);
        
        List<ModelAttachfile> result = null;
        try {
            result = dao.getAttachFileList( articleNo );
        } catch (Exception e) {
            logger.error("getAttachFileList " + e.getMessage() );
        }
        finally {
            ////session.close();            
        }
        
        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        
        ModelAttachfile result = null;
        try {
                     
            result = dao.getAttachFile ( attachFileNo );
        } catch (Exception e) {
            logger.error("getAttachFile " + e.getMessage() );
        }
        finally {
            ////session.close();            
        }
        
        return result;
  
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.insertAttachFile(attachFile);

            //session.commit();
        } catch (Exception e) {
            logger.error("insertAttachFile" + e.getMessage() );
            //session.rollback();
        }
        finally {
            //session.close();
        }        
        
        return result;
    }
    

    @Override
    public int deleteAttachFile(ModelAttachfile attachFileNo) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.deleteAttachFile(attachFileNo);
            //session.commit();
        } catch (Exception e) {
            logger.error("deleteAttachFile  " + e.getMessage() );
            //session.rollback();
        }
        finally {
            //session.close();
        }        
        
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int articleNo) {
    //IDaoBoard dao = new DaoBoard(session);
        
        List<ModelComments> result = null;
        try {
            result = dao.getCommentList( articleNo );
        } catch (Exception e) {
            logger.error("getAttachFileList " + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentNo) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        
        ModelComments result = null;
        try {
                     
            result = dao.getComment ( commentNo );
        } catch (Exception e) {
            logger.error("getComment " + e.getMessage() );
        }
        finally {
            //session.close();            
        }
        
        return result;
  
    }

    @Override
    public int insertComment(ModelComments comment) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.insertComment(comment);

            //session.commit();
        } catch (Exception e) {
            logger.error("insertComment" + e.getMessage() );
            //session.rollback();
        }
        finally {
            //session.close();
        }        
        
        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
      //SqlSession session = sqlMapper.openSession();
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.updateComment(updateValue, searchValue);
            //session.commit();
        } catch (Exception e) {
            logger.error("updateComment " + e.getMessage() );
            //session.rollback();
        }
        finally {
            //session.close();
        }        
        
        return result;
    }

    @Override
    public int deleteComment(ModelComments commentNo) {
        //IDaoBoard dao = new DaoBoard(session);
        
        int result = -1;
        try {
            result = dao.deleteComment(commentNo);
            //session.commit();
        } catch (Exception e) {
            logger.error("deleteComment  " + e.getMessage() );
            //session.rollback();
        }
          
        
        return result;
    }


    public IDaoBoard getDao() {
        return dao;
    }

    public void setDao(IDaoBoard dao) {
        this.dao = dao;
    }
    
}
