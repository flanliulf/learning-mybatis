package com.fancyliu.mybatisplusdemo.generator.demo.service;

import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Student;

public interface TransPropagationService {

    void testPropagation();

    void saveCascade(Student student, Grade grade);
}
