package org.hzz.mybatis.plugins;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.util.StrUtil;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 用于生成表对应的常量类
 * 该常量类的字段是数据库对应的字段
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/18
 */
@Slf4j
public class ConstantClassGeneratorPlugin extends PluginAdapter {
    private static final String path = "TableFieldsTemplate.properties";
    // 模板位置
    private static final String templateFtlDir = "templates/ftl";
    private static final String fullQualify = "%s.%sFields";

    /**
     * 通过配置文件赋值
     * TableFieldsTemplate.properties
     * generatorConfig.xml
     */
    private static String templateFile;
    private static String targetPackage;
    private static String author;

    @Override
    public boolean validate(List<String> warnings) {
        // 这个properties来自generatorConfig.xml的解析<plugin>
        log.info("你好: {}.这是我自己写的插件",properties.get("pkmer"));
        try {
            ClassPathResource resource = new ClassPathResource(path);
            // 合并我们自定义的配置TableFieldsTemplate.properties
            properties.load(resource.getInputStream());
            // 确定优先级以TableFieldsTemplate.properties > generatorConfig.xml为优先级

            // 配置在TableFieldsTemplate.properties文件，直接撼死
            templateFile = properties.getProperty("templateFile");
            author = properties.getProperty("author");
            // 有包名不断变化，我配置在generatorConfig.xml以它为优先级
            targetPackage = properties.getProperty("targetPackage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {

        // 获取到generatorConfig.xml配置的信息
        String targetProject = context.getJavaModelGeneratorConfiguration().getTargetProject();
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String className = StrUtil.toCamelCase(tableName);

        try (StringWriter out = new StringWriter()){
            // 配置 FreeMarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
            cfg.setClassLoaderForTemplateLoading(
                    Thread.currentThread().getContextClassLoader(),
                    templateFtlDir
            );
            cfg.setDefaultEncoding("UTF-8");


            // 处理数据
            Map<String,Object> root = new HashMap<>();
            root.put("targetPackage",targetPackage);
            root.put("author", author);
            root.put("data", LocalDate.now().toString());
            root.put("tableName",tableName);
            root.put("templateFile", templateFile);
            List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
            root.put("columns",columns);
            root.put("className", className);

            // 获取模版
            Template template = cfg.getTemplate(templateFile);
            // 输出到控制台，一边测试
            // Writer writer = new OutputStreamWriter(System.out);

            // 生成模版数据
            template.process(root,out);


            File dir = new File(targetProject + "/" + targetPackage.replace('.', '/'));
            // 插件生成的路径 D:\gitee\challenges\videos-online\api\app-mbg\src\main\java\org\hzz\types
            // 代码运行生成的路径: D:\gitee\challenges\videos-online\api\src\main\java\org\hzz\types
            log.info(dir.getAbsolutePath());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 创建Java文件
            File file = new File(dir, className + "Fields.java");
            try (FileWriter fileWriter = new FileWriter(file)) {
                // Write content to a file
                fileWriter.write(out.toString());
            }
            // 这里使用freemark来生成
            return Collections.emptyList();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
