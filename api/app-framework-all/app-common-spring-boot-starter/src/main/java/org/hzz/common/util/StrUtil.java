package org.hzz.common.util;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/18
 */
public class StrUtil {

    /**
     * 下划线转驼峰(Camel Case)
     * @param input 原始字符串
     * @return 驼峰命名字符串
     */
    public static String toCamelCase(String input){
        if(input == null || input.isEmpty() || input.isBlank()){
            return input;
        }

        StringBuilder result = new StringBuilder();
        String[] words = input.split("_");

        for (String word: words){
            if(!word.isEmpty()){
                result.append(Character.toUpperCase(word.charAt(0)));
                if(word.length() > 0){
                    result.append(word.substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }
}
