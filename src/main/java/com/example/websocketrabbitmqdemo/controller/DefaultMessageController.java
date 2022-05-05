package com.example.websocketrabbitmqdemo.controller;

import com.example.websocketrabbitmqdemo.dto.request.cases.CasesRequest;
import com.example.websocketrabbitmqdemo.dto.request.defaultmessage.DefaultMessageRequest;
import com.example.websocketrabbitmqdemo.dto.response.cases.CasesResponse;
import com.example.websocketrabbitmqdemo.dto.response.defaultmessage.DefaultMessageResponse;
import com.example.websocketrabbitmqdemo.service.DefaultMessageService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import io.swagger.annotations.*;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Default Message 預設訊息")
@RestController
@RequestMapping(value = "/api")
public class DefaultMessageController {

    @Autowired
    private DefaultMessageService defaultMessageService;

    @ApiOperation(value = "建立預設訊息", notes = "create default message")
    @PostMapping(value = "/createDefaultMessage")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DefaultMessageResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo createDefaultMessage(
            @ApiParam(value = "defaultMessageRequest") @RequestBody DefaultMessageRequest defaultMessageRequest) throws MqttException {
        return defaultMessageService.createDefaultMessage(defaultMessageRequest);
    }

    @ApiOperation(value = "取得商戶所有預設訊息", notes = "get default message by merchant id")
    @GetMapping(value = "/getDefaultMessageByMerchantId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DefaultMessageResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo getDefaultMessageByMerchantId(
            @ApiParam(value = "merchant id") @RequestParam(value = "merchantId") String merchantId) throws MqttException {
        return defaultMessageService.getDefaultMessageByMerchantId(merchantId);
    }

    @ApiOperation(value = "取得商戶指定類型的預設訊息", notes = "get default message by merchant id and message type")
    @GetMapping(value = "/getDefaultMessageByMerchantIdAndType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DefaultMessageResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo getDefaultMessageByMerchantIdAndType(
            @ApiParam(value = "merchant id") @RequestParam(value = "merchantId") String merchantId,
            @ApiParam(value = "default message type") @RequestParam(value = "defaultMessageType") String defaultMessageType) throws MqttException {
        return defaultMessageService.getDefaultMessageByMerchantIdAndType(merchantId, defaultMessageType);
    }

    @ApiOperation(value = "更新預設訊息", notes = "update default message")
    @PostMapping(value = "/updateDefaultMessage")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DefaultMessageResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo updateDefaultMessage(
            @ApiParam(value = "defaultMessageRequest") @RequestBody DefaultMessageRequest defaultMessageRequest) throws MqttException {
        return defaultMessageService.updateDefaultMessage(defaultMessageRequest);
    }

    @ApiOperation(value = "刪除預設訊息", notes = "delete default message")
    @DeleteMapping(value = "/deleteDefaultMessage")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DefaultMessageResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo deleteDefaultMessage(
            @ApiParam(value = "merchant id") @RequestParam(value = "merchantId") String merchantId,
            @ApiParam(value = "default message type") @RequestParam(value = "defaultMessageType") String defaultMessageType) throws MqttException {
        return defaultMessageService.deleteDefaultMessageByMerchantIdAndType(merchantId, defaultMessageType);
    }

}
