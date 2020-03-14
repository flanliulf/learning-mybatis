package com.fancyliu.mybatisplusdemo.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * <p>
 * 通过junit test 生成代码
 * 演示：自定义代码模板
 * 默认不会覆盖已有文件，如果需要覆盖，配置GlobalConfig.setFileOverride(true)
 * </p>
 *
 * @author yuxiaobin
 * @date 2018/11/29
 */
public class MpGeneratorTest {

    @Test
    public void generateCode() {
        generate("demo", "t_student,t_grade");
    }

    private void generate(String moduleName, String... tableNamesInclude){
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("fancyliu");


        // service接口不采用 I 开头的模式
        gc.setServiceName("%sService");
        gc.setOpen(false);
        //默认不覆盖，如果文件存在，将不会再生成，配置true就是覆盖
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus-demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("com.fancyliu.mybatisplusdemo.generator");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.fancyliu.mybatisplusdemo.generator.common.BaseEntity");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.fancyliu.mybatisplusdemo.generator.common.BaseController");
        strategy.setInclude(tableNamesInclude);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        strategy.entityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);


        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

//        configCustomizedCodeTemplate(mpg);
//        configInjection(mpg);

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称,如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        mpg.execute();
    }

    /**
     * 自定义模板
     * @param mpg
     */
    private void configCustomizedCodeTemplate(AutoGenerator mpg){
        //配置 自定义模板
        TemplateConfig templateConfig = new TemplateConfig()
                .setEntity("templates/MyEntityTemplate.java")//指定Entity生成使用自定义模板
                .setXml(null);//不生成xml
        mpg.setTemplate(templateConfig);
    }

    /**
     * 配置自定义参数/属性
     *
     * @param mpg
     */
    private void configInjection(AutoGenerator mpg){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
                /*
                自定义属性注入: 模板配置：abc=${cfg.abc}
                 */
            }
        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/MyEntityTemplate.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 指定模板生，自定义生成文件到哪个地方
//                return "D:/abc";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }
}
