package com.example.demo.commonutils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ModelUtils {

    protected JSONObject json = new JSONObject();

    /**
     * 生成
     * @param varMap            字段和字段类型map
     * @param className         类名
     * @param baseClassName     需要继承的类名
     * @param packageName       包名
     */
    public void getModelJava(HashMap<String, String> varMap, String filePath,String className, String baseClassName, String packageName) {
        if (varMap == null || className == null || baseClassName == null || packageName == null){
            return;
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //生成文件
            String fileName = className + ".java";
            File file = new File(filePath, fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("是否成功=" + newFile);
            }
            //1.拼接文件内容
            StringBuilder classStr = new StringBuilder();
            classStr.append(ModelConst.PACKAGE.replace("#package#", packageName));
            classStr.append(ModelConst.CLASS_NAME.replace("#CLASS_NAME#", className).replace("#BASE_CLASS_NAME#", baseClassName));
            //1.1循环设置字段变量
            for (String var : varMap.keySet()) {
                classStr.append(ModelConst.VAR.replace("#VAR_NAME#", var).replace("#VAR_TYPE#", varMap.get(var)));
            }
            classStr.append(ModelConst.NEXT_LINE);
            //1.2循环设置字段get和set方式
            for (String var : varMap.keySet()) {
                classStr.append(ModelConst.GET_VAR.replace("#vAR_NAME#", var).replace("#VAR_NAME#", var.substring(0, 1).toUpperCase().concat(var.substring(1))).replace("#VAR_TYPE#", varMap.get(var)));
                classStr.append(ModelConst.SET_VAR.replace("#vAR_NAME#", var).replace("#VAR_NAME#", var.substring(0, 1).toUpperCase().concat(var.substring(1))).replace("#VAR_TYPE#", varMap.get(var)));
            }
            classStr.append(ModelConst.NEXT_LINE);
            classStr.append(ModelConst.ENG);
            //写入文件中
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write(classStr.toString());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    //关闭文件流
                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成
     * @param varMap            字段和字段类型map
     * @param className         类名
     * @param tableName         表名
     */
    public void getSql(HashMap<String, String> varMap, String filePath,String className, String tableName) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String fileName = className + ".sql";
            File file = new File(filePath, fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("是否成功=" + newFile);
            }
            StringBuilder classStr = new StringBuilder();
            //开头
            classStr.append(SqlConst.TITLE.replace("#TABLE_NAME#", tableName));
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
