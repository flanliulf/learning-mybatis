package com.fancyliu.mybatisplusdemo.generator.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fancyliu.mybatisplusdemo.MybatisPlusDemoApplicationTests;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Student;
import com.fancyliu.mybatisplusdemo.generator.demo.service.TransPropagationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransPropagationServiceImplTest extends MybatisPlusDemoApplicationTests {

    @Autowired
    private TransPropagationService transPropagationService;


    @Test
    public void testPropagation() {
        transPropagationService.testPropagation();
    }

    @Test
    public void saveCascade() {

        Grade grade = new Grade();
        grade.setName("三年二班");

        Student student = new Student();
        student.setName("周杰伦");
        student.setAge(18);

        transPropagationService.saveCascade(student, grade);

    }
}