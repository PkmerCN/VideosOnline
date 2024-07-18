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
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于生成表对应的常量类
 * 该常量类的字段是数据库对应的字段
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/18
 */
@Slf4j
public class ConstantClassGeneratorPlugin extends PluginAdapter {
    // todo 配置一个properties
    private static final String templateFile = "TableFields.ftl";
    private static final String targetPackage = "targetPackage";
    private static  String fullQualify = "%s.%sFields";

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<>();

        // 获取到generatorConfig.xml配置的信息
        String targetProject = context.getJavaModelGeneratorConfiguration().getTargetProject();
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String className = StrUtil.toCamelCase(tableName);

        try (StringWriter out = new StringWriter()){
            // 配置 FreeMarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
            cfg.setClassLoaderForTemplateLoading(
                    Thread.currentThread().getContextClassLoader(),
                    "templates/ftl"
            );
            cfg.setDefaultEncoding("UTF-8");
            // 获取模版
            Template template = cfg.getTemplate(templateFile);

            // 处理数据
            Map<String,Object> root = new HashMap<>();
            root.put("tableName",tableName);
            List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
            root.put("columns",columns);
            root.put("targetPackage",targetPackage);
            root.put("className", className);

            // 生成模版数据
            template.process(root,out);

            // 创建Java类
            TopLevelClass javaClass = new TopLevelClass(new FullyQualifiedJavaType(
                    String.format(fullQualify,targetPackage,className)
            ));
            // 填充内容
            javaClass.addFileCommentLine(out.toString());

            // 创建 GeneratedJavaFile 对象
            GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(
                    javaClass,targetProject,new DefaultJavaFormatter()
            );

            generatedJavaFiles.add(generatedJavaFile);

            return generatedJavaFiles;
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
