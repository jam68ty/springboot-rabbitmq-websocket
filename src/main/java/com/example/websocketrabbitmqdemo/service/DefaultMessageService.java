package com.example.websocketrabbitmqdemo.service;

import com.example.websocketrabbitmqdemo.dto.request.defaultmessage.DefaultMessageRequest;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;

public interface DefaultMessageService {

    public ResponseInfo createDefaultMessage(DefaultMessageRequest defaultMessageRequest);

    public ResponseInfo getDefaultMessageByMerchantId(String merchantId);

    public ResponseInfo getDefaultMessageByMerchantIdAndType(String merchantId, String messageType);

    public ResponseInfo updateDefaultMessage(DefaultMessageRequest defaultMessageRequest);

    public ResponseInfo deleteDefaultMessageByMerchantIdAndType(String merchantId, String messageType);
}
