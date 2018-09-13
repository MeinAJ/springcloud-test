package com.example.demo.commonutils;

public class ModelConst {

    public static String PACKAGE = "package #package#;\n\n";

    public static String CLASS_NAME = "public class #CLASS_NAME# extends #BASE_CLASS_NAME# {\n\n";

    public static String VAR = "\tprivate #VAR_TYPE# #VAR_NAME#;\n";

    public static String SET_VAR = "\tpublic void set#VAR_NAME#(#VAR_TYPE# #vAR_NAME#) {\n" + "\t\tthis.#vAR_NAME# = #vAR_NAME#;\n" + "\t}\n";

    public static String GET_VAR = "\tpublic #VAR_TYPE# get#VAR_NAME#() {\n" + "\t\treturn #vAR_NAME#;\n" + "\t}\n";

    public static String ENG = "}";

    public static String NEXT_LINE = "\n";
}
