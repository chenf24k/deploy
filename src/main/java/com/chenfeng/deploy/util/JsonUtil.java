package com.chenfeng.deploy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 陈枫 on 2019-08-30.
 */
public class JsonUtil {

    /*public static String getValueByPath(String responseJson, String jpath) {

        JSONObject jsonObject = JSON.parseObject(responseJson);
        Object obj = jsonObject;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return obj.toString();
    }


    public static String getValueByPath(JSONObject jsonObject, String jpath) {
        Object obj = jsonObject;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return obj.toString();
    }*/

    public static String getValueByPath(Object response, String jpath) {
        JSONObject jsonObject = null;
        if (response instanceof String) {
            jsonObject = JSON.parseObject((String) response);
        }
        Object obj = jsonObject;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return obj.toString();
    }
}
