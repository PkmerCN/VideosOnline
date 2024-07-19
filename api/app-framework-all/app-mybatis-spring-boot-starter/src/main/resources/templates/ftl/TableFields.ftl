package ${targetPackage};

/**
* This class contains the database column names for the ${tableName} table.
* Generator by ${templateFile}
*/
public class ${className}Fields {
<#list columns as column>
    /**
    * ${column.remarks}
    */
    public static final String ${column.actualColumnName?upper_case} = "${column.actualColumnName}";
</#list>
}