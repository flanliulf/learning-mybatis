package com.fancyliu.mybatisplusdemo.generator.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Student;
import com.fancyliu.mybatisplusdemo.generator.demo.mapper.GradeMapper;
import com.fancyliu.mybatisplusdemo.generator.demo.mapper.StudentMapper;
import com.fancyliu.mybatisplusdemo.generator.demo.service.GradeService;
import com.fancyliu.mybatisplusdemo.generator.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author fancyliu
 * @since 2020-03-02
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public Student saveStudent(Student student) {
        int insert = this.studentMapper.insert(student);
        log.info("saveStudent return : {}", student);
        return student;
    }


}
