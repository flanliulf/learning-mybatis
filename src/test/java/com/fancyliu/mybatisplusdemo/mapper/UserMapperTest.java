package com.fancyliu.mybatisplusdemo.mapper;

import com.fancyliu.mybatisplusdemo.MybatisPlusDemoApplicationTests;
import com.fancyliu.mybatisplusdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class UserMapperTest extends MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        log.info("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}