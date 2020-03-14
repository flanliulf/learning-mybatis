package com.fancyliu.mybatisplusdemo.generator.demo.service;

import com.fancyliu.mybatisplusdemo.generator.demo.entity.Grade;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author fancyliu
 * @since 2020-03-02
 */
public interface GradeService extends IService<Grade> {

    Grade saveParent();

    void saveChildren();

    Grade saveGrade(Grade grade);

}
