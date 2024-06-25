package org.hx.aisite.common.server;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationOutput;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.ResultCallback;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.JsonUtils;
import io.reactivex.Flowable;
import org.springframework.stereotype.Component;

/**
 * 千帆大模型API服务 ERNIE-3.5-8K
 *
 * @author fyh
 * @date 2024/6/14 9:31
 **/
@Component
public class AiChatServer {

    private final static String apiKey = "sk-14837c59ea294c95a2efbf85bfd5fa7d";

    public String qwenQuickStart(String prompt)
            throws NoApiKeyException, ApiException, InputRequiredException {
        Generation gen = new Generation();
        GenerationParam param = GenerationParam.builder().model(Generation.Models.QWEN_TURBO).prompt(prompt).apiKey(apiKey)
                .topP(0.8).build();
        GenerationResult result = gen.call(param);
        GenerationOutput output = result.getOutput();
        System.out.println("result = " + result);
        return output.getText();
    }

    public void qwenQuickStartCallback(String prompt)
            throws NoApiKeyException, ApiException, InputRequiredException, InterruptedException {
        Generation gen = new Generation();
        GenerationParam param = GenerationParam.builder().model(Generation.Models.QWEN_TURBO).prompt(prompt).apiKey(apiKey)
                .topP(0.8).build();
        Semaphore semaphore = new Semaphore(0);
        gen.call(param, new ResultCallback<GenerationResult>() {

            @Override
            public void onEvent(GenerationResult message) {
                System.out.println(message);
            }

            @Override
            public void onError(Exception ex) {
                System.out.println(ex.getMessage());
                semaphore.release();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                semaphore.release();
            }

        });
        semaphore.acquire();
    }

//    public static void main(String[] args) {
//        try {
//            qwenQuickStart();
//            qwenQuickStartCallback();
//        } catch (ApiException | NoApiKeyException | InputRequiredException
//                | InterruptedException e) {
//            System.out.println(String.format("Exception %s", e.getMessage()));
//        }
//        System.exit(0);
//    }
}
