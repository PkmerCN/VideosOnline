package org.hzz.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 自定义生成代码的注释
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public class MyCommentGenerator extends DefaultCommentGenerator {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private String authorDoc;
    private String versionDoc;
    private String dateDoc;

    public MyCommentGenerator() {
        authorDoc = " * @author 胖卡\n";
        versionDoc = " * @version 1.0.0\n";
        dateDoc = String.format(" * @date %s", LocalDate.now().format(dateTimeFormatter));
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb
                .append(" * generated by MyBatis Generator.\n")
                .append(String.format(" * %s(%s) \n", introspectedTable.getFullyQualifiedTable(), introspectedTable.getRemarks()))
                .append(" * \n")
                .append(authorDoc)
                .append(versionDoc)
                .append(dateDoc);
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        field.addJavaDocLine(String.format("// %s.%s (%s)",
                introspectedTable.getFullyQualifiedTable(),
                introspectedColumn.getActualColumnName(),
                introspectedColumn.getRemarks()));
    }
}
