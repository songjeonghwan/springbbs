package mybatis.dao;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBook;

@Repository
public class DAOBook implements IDAOBook {
    
    @Autowired
    private SqlSession session;
    public DAOBook(SqlSession conn) {
        super();
        this.session = conn;
    }

    @Override
    public List<ModelBook> getSQLSelectAll() {
        
        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectLike(String bookname) {
        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike", "%" + bookname + "%" );
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectEqual(String bookname) {

        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual", bookname );
        
        return result;
    }

    @Override
    public int setSQLInsert(ModelBook book) {
        
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);        
        return result;
    }

    @Override
    public int setSQLInsertMulti(List<ModelBook> books) {
        
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsertMulti", books);        
        return result;
    }

    @Override
    public int setSQLInsertSequence(String bookname,
            String publisher, String year, int price, String dtm,
            boolean use_yn, int authid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) {
        
        int result = 0;
        
        Map<String, ModelBook> parameter = new HashMap<String, ModelBook>();

        parameter.put("updateValue"       , updateValue  );
        parameter.put("searchValue"       , searchValue  );
      
        result = session.update("mybatis.mapper.mapperBook.setSQLUpdate", parameter);
        
        return result;
    }

    @Override
    public int setSQLDelete(ModelBook book) {
        // TODO Auto-generated method stub
        return 0;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DAOBook() {
        super();
    }    
    
    
    
}