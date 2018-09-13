package com.example.demo.commonutils;

public class SqlConst {

    //开头
    public static String TITLE = "CREATE TABLE `#TABLE_NAME#` (\n";

    //主键,但是没设置primary key
    public static String KEY = "\t`#VAR_KEY#` #VAR_TYPE# NOT NULL comment \"#COMMENT#\",\n";

    //一般字段
    public static String VAR_NORMAL = "\t`#VAR_KEY#` #VAR_TYPE# DEFAULT NULL comment \"#COMMENT#\",\n";

    //设置主键的
    public static String SET_PRIMARY_KEY = "\tPRIMARY KEY (`#PRIMARY_KEY#`)\n";

    //结尾
    public static String END = ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

}
