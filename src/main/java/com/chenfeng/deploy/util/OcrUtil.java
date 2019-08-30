package com.chenfeng.deploy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * @author 陈枫 on 2019-08-30.
 */
public class OcrUtil {
    public static String getOcrResult(String picUrl) {
        if (picUrl == null || picUrl.trim().equals("")) {
            return "图片不能为空...";
        }

        if (picUrl.endsWith(".png") || picUrl.endsWith(".jpeg") || picUrl.endsWith(".jpg")) {
            try {
                String response = Request.Post("https://api.cloud.tencent.com/requesttc3")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .bodyForm(Form.form().add("Product", "ocr")
                                .add("Action", "GeneralBasicOCR")
                                .add("Version", "2018-11-19")
                                .add("Region", "ap-shanghai")
                                .add("JsonData", "{\"ImageUrl\":\"" + picUrl + "\",\"LanguageType\":\"zh\"}")
                                .add("SecretId", "AKID9MOhsCP4lDYknBts17XzPkyhpqhBQ2V9")
                                .add("SecretKey", "fAVks5IQNF2gM0mJhvE661shNBTZVI0Z").build())
                        .execute()
                        .returnContent()
                        .asString();
                System.out.println(response);
                String result = JsonUtil.getValueByPath(response, "body/Response");
                JSONObject jsonObject = JSON.parseObject(result);
                JSONArray array = jsonObject.getJSONArray("TextDetections");

                StringBuilder sb = new StringBuilder();
                try {
                    for (Object o : array
                    ) {
                        JSONObject j = (JSONObject) o;
                        sb.append(j.getString("DetectedText"));
                    }
                }catch (NullPointerException e){
                    return "请检查地址";
                }

                return String.valueOf(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return "格式不对哦...";
        }
        return "接口响应失败...";
    }


}
