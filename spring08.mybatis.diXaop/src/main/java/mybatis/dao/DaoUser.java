package mybatis.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelComments;
import mybatis.model.ModelUser;


@Repository("userDao")
public class DaoUser implements IDaoUser {
 
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    
    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DaoUser(SqlSession session) {
        super();
        this.session = session;
    }

    public DaoUser() {
        super();
    }
    
    @Override
    public int insertUser(ModelUser user) {

        return session.insert("mybatis.mapper.mapperUser.insertUser", user);        

    }

    @Override
    public ModelUser login(ModelUser user) {
        return session.selectOne("mybatis.mapper.mapperUser.login", user);
    }

    @Override
    public ModelUser logout(String userid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue ,ModelUser searchValue) {
  
        Map<String, ModelUser> map = new HashMap<String, ModelUser>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        return session.update("mybatis.mapper.mapperUser.updateUserInfo", map );    
        
       
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
