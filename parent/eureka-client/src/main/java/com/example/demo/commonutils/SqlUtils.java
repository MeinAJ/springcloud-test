package com.example.demo.commonutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SqlUtils {

    public static void getSql() {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            HashMap<String, String> varMap = new HashMap<>();
            varMap.put("id", "bigint(20)");
            varMap.put("name", "varchar(200)");
            varMap.put("nameEng", "varchar(200)");
            varMap.put("age", "integer");
            varMap.put("isDelete", "tinyint(1)");

            String filePath = "E:\\filetest";
            String fileName = "test.sql";
            File file = new File(filePath, fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("是否成功=" + newFile);
            }


            StringBuilder classStr = new StringBuilder();
            //开头
            classStr.append(SqlConst.TITLE.replace("#TABLE_NAME#", "t_goods"));
            //设置主键开头
            classStr.append(SqlConst.KEY.
                    replace("#VAR_KEY#","id").
                    replace("#VAR_TYPE#","bigint(20)").
                    replace("#COMMENT#","主键"));
            //设置一般字段
            classStr.append(SqlConst.VAR_NORMAL.
                    replace("#VAR_KEY#","name").
                    replace("#VAR_TYPE#","varchar(200)").
                    replace("#COMMENT#","姓名"));
            //设置主键结尾
            classStr.append(SqlConst.SET_PRIMARY_KEY.replace("#PRIMARY_KEY#","id"));
            //结尾
            classStr.append(SqlConst.END);
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write(classStr.toString());
            bw.flush();

            System.out.println("结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null && fw != null) {
                try {
                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
