package com.example.websocketrabbitmqdemo.controller;

import com.example.websocketrabbitmqdemo.dto.request.DialogueRequest;
import com.example.websocketrabbitmqdemo.dto.response.DialogueResponse;
import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "Messager 對話")
@RestController
public class MessageController {


    @Autowired
    private DialogueService dialogueService;

    @Autowired
    HttpServletRequest httpServletRequest;

//	@HktvEcoMartLogCollectMethod
    @ApiOperation(value = "查詢對話", notes = "查詢user的對話")
    @GetMapping(value = "/dialogue")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DialogueResponse.class) })
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo getMessage(
            @ApiParam(value = "起始索引") @RequestParam(value = "startIndex", required = false, defaultValue = "0") int startIndex,
            @ApiParam(value = "筆數") @RequestParam(value = "size", required = false, defaultValue = "0") int size) {
        return dialogueService.getDialogues(startIndex, size);
    }


    @ApiOperation(value = "新增對話", notes = "新增對話")
    @PostMapping(value = "/dialogue")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "success", response = DialogueResponse.class) })
    public ResponseInfo dialoguePost(@RequestBody DialogueRequest request) throws Exception {
        return dialogueService.createDialogue(request);
    }


}
