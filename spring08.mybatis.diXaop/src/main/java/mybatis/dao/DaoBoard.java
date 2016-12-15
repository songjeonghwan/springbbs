package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;

@Repository("boardDao")
public class DaoBoard implements IDaoBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public DaoBoard(SqlSession conn) {
        super();
        this.session = conn;
    }

    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getBoardName(String boardcd) {
        String result = "";        
        result = session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;        
        result = session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        List<ModelBoard> result = null;        
        result = session.selectList("mybatis.mapper.mapperBoard.getBoardList");        
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        Map<String, ModelBoard> result = null;        
        result = session.selectMap("mybatis.mapper.mapperBoard.getBoardListResultMap", "boardcd");        
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBoard.insertBoard", board);        
        return result;
    }

    @Override
    public int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard) {
        int result = 0 ;
        Map<String, ModelBoard> map = new HashMap<String, ModelBoard>();
        map.put("updateValue", updateBoard);
        map.put("searchValue", searchBoard);
        result = session.insert("mybatis.mapper.mapperBoard.updateBoard", map);        
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBoard.deleteBoard", board);        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        List<ModelBoard> result = null ;
        result = session.selectList("mybatis.mapper.mapperBoard.getBoardSearch", board);        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBoard.insertBoardList", list);        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int result = 0 ;
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        
        result = session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord", map);        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        List<ModelArticle> result = null ;
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd"   , boardcd    );
        map.put("searchWord", "%"+searchWord+"%" );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        result = session.selectList("mybatis.mapper.mapperBoard.getArticleList", map);        
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        ModelArticle result = null ;
        result = session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleNo);        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int result = -1 ;
        result = session.insert("mybatis.mapper.mapperBoard.insertArticle", article );        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        int result = -1 ;
        
        Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        result = session.insert("mybatis.mapper.mapperBoard.updateArticle", map );    
        
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        int result = -1 ;       
        result = session.insert("mybatis.mapper.mapperBoard.deleteArticle", article ); 
        return result;
    }

    @Override
    public int increaseHit(int articleNo) {
        int result = -1 ;       
        result = session.update("mybatis.mapper.mapperBoard.increaseHit", articleNo ); 
        return result;
    }

    @Override
    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
        ModelArticle result = null ;       
        result = session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", hashmap ); 
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {
        ModelArticle result = null ;       
        result = session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", hashmap ); 
        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        ModelAttachfile result = null ;       
        result = session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachFileNo ); 
        return result;
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        List<ModelAttachfile> result = null ;      //경로는 mapper~.xml파일의 id와 이름 동일 
        result = session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", articleNo ); 
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        int result = -1 ;
        result = session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile );        
        return result;
    }

    @Override
    //mapper~.xml parameterType="ModelAttachfile" 값과 동일하게
    public int deleteAttachFile(ModelAttachfile attachFileNo) {
        int result = 0 ;
        result = session.delete("mybatis.mapper.mapperBoard.deleteAttachFile", attachFileNo);        
        return result;
    }

    @Override
    public int insertComment(ModelComments comment) {
        int result = -1 ;
        result = session.insert("mybatis.mapper.mapperBoard.insertComment", comment );        
        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        int result = -1 ;
        
        Map<String, ModelComments> map = new HashMap<String, ModelComments>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        result = session.insert("mybatis.mapper.mapperBoard.updateComment", map );    
        
        return result;
    }

    @Override
    public int deleteComment(ModelComments commentNo) {
        int result = -1 ;       
        result = session.delete("mybatis.mapper.mapperBoard.deleteComment", commentNo ); 
        return result;
    }

    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments result = null ;       
        result = session.selectOne("mybatis.mapper.mapperBoard.getComment", commentNo ); 
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        List<ModelComments> result = null ;      //경로는 mapper~.xml파일의 id와 이름 동일 
        result = session.selectList("mybatis.mapper.mapperBoard.getCommentList", articleNo ); 
        return result;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DaoBoard() {
        super();
    }

    
}
