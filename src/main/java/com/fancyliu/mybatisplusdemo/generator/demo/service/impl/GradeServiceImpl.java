package com.fancyliu.mybatisplusdemo.generator.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.fancyliu.mybatisplusdemo.generator.demo.mapper.GradeMapper;
import com.fancyliu.mybatisplusdemo.generator.demo.service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author fancyliu
 * @since 2020-03-02
 */
@Service
@Slf4j
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Grade saveParent() {
        Grade parent = new Grade();
        parent.setName("parent_grade");
        int insert = gradeMapper.insert(parent);

        log.info("saveParent return : {}", parent);
        return parent;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public Grade saveGrade(Grade grade) {
        int insert = gradeMapper.insert(grade);

        log.info("saveGrade return : {}", grade);
        return grade;
    }

    @Override
    public void saveChildren() {
        saveChild1();
        int error = 1 / 0;
        saveChild2();

        log.info("saveChildren");
    }

    public Grade saveChild1() {
        Grade child = new Grade();
        child.setName("child_grade_1");
        int insert = gradeMapper.insert(child);

        log.info("saveChild1 return : {}", child);
        return child;
    }

    public Grade saveChild2() {
        Grade child = new Grade();
        child.setName("child_grade_2");
        int insert = gradeMapper.insert(child);

        log.info("saveChild2 return : {}", child);
        return child;
    }
}
