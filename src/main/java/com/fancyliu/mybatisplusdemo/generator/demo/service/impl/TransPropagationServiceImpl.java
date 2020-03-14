package com.fancyliu.mybatisplusdemo.generator.demo.service.impl;

import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Student;
import com.fancyliu.mybatisplusdemo.generator.demo.service.GradeService;
import com.fancyliu.mybatisplusdemo.generator.demo.service.StudentService;
import com.fancyliu.mybatisplusdemo.generator.demo.service.TransPropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransPropagationServiceImpl implements TransPropagationService {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;


    @Override
    public void testPropagation() {
        gradeService.saveParent();

        gradeService.saveChildren();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCascade(Student student, Grade grade) {
        grade = this.gradeService.saveGrade(grade);

        student.setGradeId(grade.getId());

        int i = 1 / 0;

        student = studentService.saveStudent(student);

    }
}
