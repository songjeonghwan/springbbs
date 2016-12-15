package mybatis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelUser;

public interface IDaoUser {
    
    
    int insertUser(ModelUser user);
    
    ModelUser login(ModelUser user);
    
    ModelUser logout(String userid);
    
    int updateUserInfo(ModelUser updateValue, ModelUser searchValue);
    
    int updatePasswd(ModelUser updateValue, ModelUser searchValue);
    
    int deleteUser(ModelUser user);
    
    ModelUser selectUserOne(ModelUser userid);
    
    List<ModelUser> selectUserList(ModelUser userid);
    
    
    //resultType=List<ModelUser>// selectUserList( //parameterType=ModelUser// userid);
}
