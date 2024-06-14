package org.hx.aisite.common.server;

import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 千帆大模型API服务 ERNIE-3.5-8K
 *
 * @author fyh
 * @date 2024/6/14 9:31
 **/
@Component
public class AiChatServer {
    public static final String API_KEY = "atTLLYWLVqYAVyVD8STvhT7E";
    public static final String SECRET_KEY = "xhH2vpI1kYWs3qdlxmy2jQ6RMadNUbR3";

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public String chat(com.alibaba.fastjson2.JSONObject requestBody) throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody.toJSONString());
        Request request = new Request.Builder()
            .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions?access_token=" + getAccessToken())
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .build();
        Response response = HTTP_CLIENT.newCall(request).execute();

        String chatResponse = "";
        if (!StringUtils.isEmpty(response.body())) {
            chatResponse = response.body().string();
        }

        return chatResponse;
    }


    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }
}
