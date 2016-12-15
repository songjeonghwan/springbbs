package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.dao.*;
import mybatis.model.ModelBook;

public class ServiceBook implements IServiceBook {

    private static Logger logger = LoggerFactory.getLogger(ServiceBook.class);
    
    //public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();
    
    private SqlSession session;
    
    @Override
    public List<ModelBook> getSQLSelectAll() {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectAll();
        } catch (Exception e) {
            logger.error("getSQLSelectAll" + e.getMessage() );
        }
        
        //session.close();
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectLike(String expr) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectLike(expr);
        } catch (Exception e) {
            logger.error("getSQLSelectLike" + e.getMessage() );
        }
        
        //session.close();
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectEqual(String expr) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectEqual(expr);
        } catch (Exception e) {
            logger.error("getSQLSelectEqual" + e.getMessage() );
        }
        
        //session.close();
        
        return result;
    }

    @Override
    public int setSQLInsert(ModelBook book) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        int result = -1;
        try {
            result = dao.setSQLInsert(book);
        } catch (Exception e) {
            logger.error("setSQLInsert" + e.getMessage() );
            session.rollback();
        }
        finally {
            session.commit();
            //session.close();
        }        
        
        return result;
    }

    @Override
    public int setSQLInsertMulti(List<ModelBook> books) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        int result = -1;
        try {
            for(int i=0; i<books.size(); i=i+1) {
                result += dao.setSQLInsert(books.get(i));
            }
        } catch (Exception e) {
            logger.error("setSQLInsert" + e.getMessage() );
            session.rollback();
        }
        finally {
            session.commit();
            //session.close();
        }        
        
        return result;
    }

    @Override
    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        int result = -1;
        try {
            result = dao.setSQLUpdate(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("setSQLUpdate" + e.getMessage() );
            session.rollback();
        }
        finally {
            session.commit();
            //session.close();
        }        
        
        return result;
    }

    @Override
    public int setSQLDelete(String bookname) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setTransCommit(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        int result = -1;
        
        try {
            dao.setSQLDelete(delBook);
            dao.setSQLInsert(insBook);
            dao.setSQLUpdate(updBook, searchBook);
            
            result = 1;
        } catch (Exception e) {
            logger.error("setTransCommit" + e.getMessage() );
            session.rollback();
        }
        finally {
            session.commit();
            //session.close();
        }
      
        return result;
    }

    @Override
    public int setTransRollback(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook) {
        int result = -1;
        
        //SqlSession session = sqlMapper.openSession();
        IDAOBook dao = new DAOBook(session);
        
        try {
            dao.setSQLDelete(delBook);
            dao.setSQLInsert(insBook);
            dao.setSQLUpdate(updBook, searchBook);

            result = 1;
            
            throw new Exception("rollback test");
            
        } catch (Exception e) {
            logger.error("setTransCommit" + e.getMessage() );
            session.rollback();
            result = -1;
        }
        finally {
            session.commit();
            //session.close();
        }
      
        return result;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public ServiceBook() {
        super();
    }


}