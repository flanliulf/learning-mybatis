package com.fancyliu.mybatisplusdemo.generator.demo.service;

import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学生表 服务类
 * </p>
 *
 * @author fancyliu
 * @since 2020-03-02
 */
public interface StudentService extends IService<Student> {



    Student saveStudent(Student student);

}
