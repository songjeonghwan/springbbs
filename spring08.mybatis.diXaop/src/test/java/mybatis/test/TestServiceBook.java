package mybatis.test;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.*;

import org.apache.ibatis.session.*;

import mybatis.dao.*;
import mybatis.model.*;
import mybatis.service.*;

public class TestServiceBook {
    
    @Test
    public void testGetSQLSelectAll() {
        IServiceBook serivce = new ServiceBook();
        List<ModelBook> result = serivce.getSQLSelectAll();        
        assertSame(result.size(), 4);
    }
    
    @Test
    public void testGetSQLSelectLike() {
        IServiceBook serivce = new ServiceBook();
        List<ModelBook> result = serivce.getSQLSelectLike("SQL");        
        assertSame(result.size(), 2);
    }
    
    @Test
    public void testGetSQLSelectEqual() {
        IServiceBook serivce = new ServiceBook();
        List<ModelBook> result = serivce.getSQLSelectEqual("JAVA");        
        assertSame(result.size(), 1);
    }
    
    @Test
    public void testSetSQLInsert() {
        
        ModelBook book = new ModelBook();
        book.setAuthid(10);
        book.setBookname("test");
        book.setDtm("2016-11-12");
        book.setPrice(10000);
        book.setPublisher("내가");
        book.setUse_yn(true);
        book.setYear("2016");
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setSQLInsert(book);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLUpdateWith_Bookid() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(2);
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLUpdateWith_BookidAndBookname() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(3);
        searchValue.setBookname("JAVA");
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLDeleteWith_Bookid() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(2);
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    

    
    @Test
    public void testSetTransCommit() {

        ModelBook delBook = new ModelBook();
        delBook.setBookid(1);
        
        ModelBook insBook = new ModelBook();
        insBook.setAuthid(10);
        insBook.setBookname("trans test insert");
        insBook.setDtm("2016-11-12");
        insBook.setPrice(10000);
        insBook.setPublisher("trans test insert");
        insBook.setUse_yn(true);
        insBook.setYear("2016");        
        
        ModelBook updBook = new ModelBook();
        updBook.setAuthid(10);
        updBook.setBookname("trans test update");
        updBook.setDtm("2016-11-12");
        updBook.setPrice(10000);
        updBook.setPublisher("trans test update");
        updBook.setUse_yn(true);
        updBook.setYear("2016");        

        ModelBook searchBook = new ModelBook();
        searchBook.setBookid(2);
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setTransCommit(delBook, insBook, updBook, searchBook);      
        assertSame(result, 1);
    }
    
    @Test
    public void testSetTransRollback() {

        ModelBook delBook = new ModelBook();
        delBook.setBookid(1);
        
        ModelBook insBook = new ModelBook();
        insBook.setAuthid(10);
        insBook.setBookname("trans test insert");
        insBook.setDtm("2016-11-12");
        insBook.setPrice(10000);
        insBook.setPublisher("trans test insert");
        insBook.setUse_yn(true);
        insBook.setYear("2016");        
        
        ModelBook updBook = new ModelBook();
        updBook.setAuthid(10);
        updBook.setBookname("trans test update");
        updBook.setDtm("2016-11-12");
        updBook.setPrice(10000);
        updBook.setPublisher("trans test update");
        updBook.setUse_yn(true);
        updBook.setYear("2016");        

        ModelBook searchBook = new ModelBook();
        searchBook.setBookid(2);
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setTransCommit(delBook, insBook, updBook, searchBook);      
        assertSame(result, -1);
    }
    
    @Test
    public void testSetSQLInsertMulti() {
        
        List<ModelBook> books = new ArrayList<ModelBook>();
        
        for( int i=0; i< 1; i=i+1 ){
        
            ModelBook book = new ModelBook();
            book.setAuthid(10);
            book.setBookname("insert multi " + i );
            book.setDtm("2016-11-12");
            book.setPrice(1000);
            book.setPublisher("insert multi " + i );
            book.setUse_yn(true);
            book.setYear("2016");
            
            books.add( book );            
        }
        
        IServiceBook serivce = new ServiceBook();
        int result = serivce.setSQLInsertMulti(books);        
        assertSame(result, 10);
    }
}
