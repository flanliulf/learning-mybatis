package ${package.Controller};


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.gyenno.ngs.kernel.model.builder.ResponseDataBuilder;
import com.gyenno.ngs.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if swagger2>
@Api(value = "${entity}", tags = {"${entity}接口"})
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

   @Autowired
   private ${table.serviceName} ${package.ModuleName}Service;

    @ApiOperation(value = "测试 API 服务是否 OK", notes = "如果返回 ok,说明接口服务可以正常调用", httpMethod = "GET")
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @ApiOperation(value = "查询所有${table.comment!}", notes = "查询所有的${table.comment!}列表", httpMethod = "GET")
    @GetMapping("/list")
    public ResponseData list() {
        List<${entity}> list = ${package.ModuleName}Service.list();
        return ResponseDataBuilder.success(list);
    }

    @ApiOperation(value = "新增${table.comment!}", notes = "新增${table.comment!}", httpMethod = "POST")
    @PostMapping("/add")
    public ResponseData add(@RequestBody ${entity}DTO ${package.ModuleName}DTO) {

        ${entity} ${package.ModuleName} = new ${entity}();

        // 将前端封装对象的属性(即参数)复制到 entity 中
        BeanUtil.copyProperties(${package.ModuleName}DTO, ${package.ModuleName});

        boolean save = ${package.ModuleName}Service.save(${package.ModuleName});

        if (save) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

    @ApiOperation(value = "更新${table.comment!}", notes = "更新${table.comment!}", httpMethod = "PUT")
    @PutMapping("/update")
    public ResponseData update(@RequestBody ${entity}DTO ${package.ModuleName}DTO) {

        ${entity} ${package.ModuleName} = new ${entity}();

        // 将前端封装对象的属性(即参数)复制到 entity 中
        BeanUtil.copyProperties(${package.ModuleName}DTO, ${package.ModuleName});

        boolean update = ${package.ModuleName}Service.saveOrUpdate(${package.ModuleName});
        if (update) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

    @ApiOperation(value = "删除${table.comment!}", notes = "删除${table.comment!}", httpMethod = "DELETE")
    @DeleteMapping("/delete")
    public ResponseData delete(@RequestParam Long id) {
        boolean remove = ${package.ModuleName}Service.removeById(id);

        if (remove) {
            return ResponseDataBuilder.success();
        } else {
            return ResponseDataBuilder.error();
        }
    }

}
</#if>
