package com.chenfeng.deploy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 陈枫 on 2019-08-24.
 */
public class TimeTransferUtil {
    private static final String[] str = {"yyyy", "MM", "dd", "yyyy-MM", "yyyy-MM-dd", "HH:mm:ss", "yyyy-MM-dd HH:mm:ss"
            , "y", "y-M", "y-M-d", "M"};
    private static final String tips = "你是一只美丽的沙雕。";

    public static String transferTime(String pattern) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (pattern == null || pattern.trim().equals("")) {
            return df.format(System.currentTimeMillis());
        }

        List<String> list = Arrays.asList(str);
        if (list.contains(pattern)) {
            DateFormat dfs = new SimpleDateFormat(pattern);
            return dfs.format(new Date());
        } else if (pattern.matches("^\\d+$")) {
            if (pattern.matches("\\d{10,13}")) {
                if (pattern.length() == 10) {
                    return df.format(Long.valueOf(pattern + "000"));
                }
                if (pattern.length() == 13) {
                    return df.format(Long.valueOf(pattern));
                }
                return tips;
            } else
                return tips;
        } else
            return tips;

    }

    public static void main(String[] args) {
        System.out.println(TimeTransferUtil.transferTime(""));
    }
}
