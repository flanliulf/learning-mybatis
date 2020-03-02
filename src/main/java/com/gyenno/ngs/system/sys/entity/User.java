package com.gyenno.ngs.system.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author fancyliu
 * @since 2020-02-10
 */
@Data
@TableName("sys_user")
@ApiModel(value="User对象", description="系统用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID", name = "id", example = "")
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "真实姓名", name = "realname", example = "")
    /**
     * 真实姓名
     */
    @TableField("realname")
    private String realname;

    @ApiModelProperty(value = "国家码", name = "cc", example = "")
    /**
     * 国家码
     */
    @TableField("cc")
    private String cc;

    @ApiModelProperty(value = "手机号", name = "mobile", example = "")
    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "性别(1/男，2/女)", name = "gender", example = "")
    /**
     * 性别(1/男，2/女)
     */
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "年龄", name = "age", example = "")
    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "身份证号", name = "idcardNo", example = "")
    /**
     * 身份证号
     */
    @TableField("idcard_no")
    private String idcardNo;

    @ApiModelProperty(value = "地址", name = "address", example = "")
    /**
     * 地址
     */
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "状态 (1：启用  2：冻结  3：删除）", name = "status", example = "")
    /**
     * 状态 (1：启用  2：冻结  3：删除）
     */
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建时间", name = "createdTime", example = "")
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间", name = "updatedTime", example = "")
    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除:0表示未删除,1表示已删除", name = "deleted", example = "")
    /**
     * 逻辑删除:0表示未删除,1表示已删除
     */
    @TableField("is_deleted")
    private Boolean deleted;


}
