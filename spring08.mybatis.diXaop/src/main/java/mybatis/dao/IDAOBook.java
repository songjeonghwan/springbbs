package mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import mybatis.model.ModelBook;

public interface IDAOBook {
    
    List<ModelBook> getSQLSelectAll();
    
    List<ModelBook> getSQLSelectLike(String bookname)
           ;
    
    List<ModelBook> getSQLSelectEqual(String bookname)
           ;
    
    int setSQLInsert(ModelBook book);
    
    int setSQLInsertMulti(List<ModelBook> books);
    
    int setSQLInsertSequence(String bookname, String publisher,
            String year, int price, String dtm, boolean use_yn, int authid)
           ;
    
    int setSQLUpdate(ModelBook updateValue, ModelBook searchValue)
           ;
    
    int setSQLDelete(ModelBook book);
}
