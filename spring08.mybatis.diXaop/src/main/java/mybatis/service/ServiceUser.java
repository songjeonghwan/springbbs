package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.*;
import mybatis.model.*;

@Service("userservice")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    @Qualifier("userDao")
    IDaoUser dao;
    public IDaoUser getDao() {
        return dao;
    }

    public void setDao(IDaoUser dao) {
        this.dao = dao;
    }
      
    public ServiceUser() {
        super();
    }
    
    @Override
    public int insertUser(ModelUser user) {
      //SqlSession session = sqlMapper.openSession();
        ////IDaoUser dao = new DaoUser(session);
        
        int result = -1;
        try {
            result = dao.insertUser(user);
            //session.commit();
            
        } catch (Exception e) {
            logger.error("insertUser" + e.getMessage() );
            //session.rollback();
        }
          
        
        return result;
    }

    @Override
    public ModelUser login(ModelUser user) {
        
        //SqlSession session = sqlMapper.openSession();
        //IDaoUser dao = new DaoUser(session);
        
        ModelUser result = null;
        try {
            result = dao.login(user);
            ////session.commit();
            
        } catch (Exception e) {
            logger.error("login" + e.getMessage() );
            ////session.rollback();
        }
    
        
        return result;
    }

    @Override
    public ModelUser logout(String userid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue ,ModelUser searchValue) {
        
        //IDaoUser dao = new DaoUser(session);
        
        int result = -1;
        try {
            result = dao.updateUserInfo(updateValue, searchValue);
            //session.commit();
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
            //session.rollback();
        }
    
        return result;
    }

    @Override
    public int updatePasswd(ModelUser updateValue ,ModelUser searchValue) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteUser(ModelUser user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ModelUser selectUserOne(ModelUser userid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser userid) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
