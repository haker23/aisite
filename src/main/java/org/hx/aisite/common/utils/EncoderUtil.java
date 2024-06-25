package org.hx.aisite.common.utils;

import com.alibaba.fastjson2.JSONObject;
import org.hx.aisite.common.entity.SignalEntity;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @Author: wu.shaoya
 * @Description: 编码器
 * @Date: 10:14 2019/10/31
 */
public class EncoderUtil implements Encoder.Text<SignalEntity> {

    @Override
    public String encode(SignalEntity message) throws EncodeException {
        return JSONObject.toJSONString(message);

    }

    @Override
    public void init(EndpointConfig ec) {
        //System.out.println("MessageEncoder - init method called");
    }



    @Override
    public void destroy() {
        //System.out.println("MessageEncoder - destroy method called");
    }

}

