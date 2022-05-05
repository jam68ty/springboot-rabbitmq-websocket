package com.example.websocketrabbitmqdemo.service.impl;

import com.example.websocketrabbitmqdemo.dto.request.defaultmessage.DefaultMessageRequest;
import com.example.websocketrabbitmqdemo.service.DefaultMessageService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.springframework.stereotype.Service;

@Service
public class DefaultMessageServiceImpl implements DefaultMessageService {
    @Override
    public ResponseInfo createDefaultMessage(DefaultMessageRequest defaultMessageRequest) {
        return null;
    }

    @Override
    public ResponseInfo getDefaultMessageByMerchantId(String merchantId) {
        return null;
    }

    @Override
    public ResponseInfo getDefaultMessageByMerchantIdAndType(String merchantId, String messageType) {
        return null;
    }


    @Override
    public ResponseInfo updateDefaultMessage(DefaultMessageRequest defaultMessageRequest) {
        return null;
    }

    @Override
    public ResponseInfo deleteDefaultMessageByMerchantIdAndType(String merchantId, String messageType) {
        return null;
    }

}
