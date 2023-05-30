package com.wzy.mapper;

import com.wzy.pojo.UserPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext-mybatis.xml",
        "classpath:applicationContext-spring.xml",
        "classpath:applicationContext-trans.xml",
        "classpath:springmvc.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectLogin(){
        UserPo result = userMapper.selectUserById(1);
        System.out.println(result);
    }


}
