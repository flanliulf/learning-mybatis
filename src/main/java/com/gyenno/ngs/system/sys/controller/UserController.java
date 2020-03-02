package com.gyenno.ngs.system.sys.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.gyenno.ngs.kernel.model.builder.ResponseDataBuilder;
import com.gyenno.ngs.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author fancyliu
 * @since 2020-02-10
 */
@RestController
@Api(value = "User", tags = {"User接口"})
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试 API 服务是否 OK", notes = "如果返回 ok,说明接口服务可以正常调用", httpMethod = "GET")
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @ApiOperation(value = "查询所有系统用户", notes = "查询所有的系统用户列表", httpMethod = "GET")
    @GetMapping("/list")
    public ResponseData list() {
        List<User> list = userService.list();
        return ResponseDataBuilder.success(list);
    }

    @ApiOperation(value = "新增系统用户", notes = "新增系统用户", httpMethod = "POST")
    @PostMapping("/add")
    public ResponseData add(@RequestBody UserDTO userDTO) {

        User user = new User();

        // 将前端封装对象的属性(即参数)复制到 entity 中
        BeanUtil.copyProperties(userDTO, user);

        boolean save = userService.save(user);

        if (save) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

    @ApiOperation(value = "更新系统用户", notes = "更新系统用户", httpMethod = "PUT")
    @PutMapping("/update")
    public ResponseData update(@RequestBody UserDTO userDTO) {

        User user = new User();

        // 将前端封装对象的属性(即参数)复制到 entity 中
        BeanUtil.copyProperties(userDTO, user);

        boolean update = userService.saveOrUpdate(user);
        if (update) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

    @ApiOperation(value = "删除系统用户", notes = "删除系统用户", httpMethod = "DELETE")
    @DeleteMapping("/delete")
    public ResponseData delete(@RequestParam Long id) {
        boolean remove = userService.removeById(id);

        if (remove) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

}
