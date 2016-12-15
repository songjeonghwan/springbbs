package mybatis.test;

import static org.junit.Assert.*;


import java.util.Date;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.model.ModelBoard;
import mybatis.model.ModelUser;
import mybatis.service.IServiceBoard;
import mybatis.service.IServiceUser;
import mybatis.service.ServiceBoard;
import mybatis.service.ServiceUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TsetServiceUser {
    private static SqlSession session = null;
    private static Logger logger = LoggerFactory.getLogger(TsetServiceUser.class);
    
    private static ApplicationContext context = null;
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("userservice", IServiceUser.class);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //((ClassPathXmlApplicationContext)context).close();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    
    @Test
    public void insertUser() {
        ModelUser model = new ModelUser();
        model.setUserid("song1111311a");
        model.setEmail("927902@naver.com");
        model.setPasswd("1234");
        model.setName("송정환");
        model.setMobile("mobile");
        model.setRetireYN(false);
        model.setInsertUID("sss");
        model.setInsertDT(new Date());
        model.setUpdateUID("sss");
        model.setUpdateDT(new Date());

        //IServiceUser user = new ServiceUser(session);        
        int result = service.insertUser(model);
        assertSame(result, 1);
    }

    @Test
    public void login() {
        
        ModelUser model = new ModelUser();
        
        model.setUserid("song");
        model.setPasswd("passwd");
        

        //IServiceUser user = new ServiceUser(session);        
        ModelUser result = service.login(model);
        assertEquals(result.getName(), "name" );
    }
    

    @Test
    public void logout() {


    }

    @Test
    public void updateUserInfo() {
        ModelUser updateValue = new ModelUser();
        updateValue.setEmail("email");
        updateValue.setPasswd("passwd");
        updateValue.setName("name");
        updateValue.setMobile("000000");
        updateValue.setUpdateDT(new Date());
        updateValue.setUpdateUID("updateUID");

        
        ModelUser searchValue = new ModelUser();
        searchValue.setUserno(1);

        //IServiceUser user = new ServiceUser(session);        
        int result = service.updateUserInfo(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void updatePasswd() {

    }

    @Test
    public void deleteUser() {
  
    }

    @Test
    public void selectUserOne() {
        
    }

    @Test
    public void selectUserList() {
     
    }
 
}
