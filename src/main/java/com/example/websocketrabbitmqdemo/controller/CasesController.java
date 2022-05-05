package com.example.websocketrabbitmqdemo.controller;

import com.example.websocketrabbitmqdemo.dto.request.cases.CasesRequest;
import com.example.websocketrabbitmqdemo.dto.response.cases.CasesResponse;
import com.example.websocketrabbitmqdemo.service.CaseService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import io.swagger.annotations.*;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Case 案例")
@RestController
@RequestMapping(value = "/api")
public class CasesController {

    @Autowired
    private CaseService caseService;

    @ApiOperation(value = "建立案例", notes = "create case")
    @PostMapping(value = "/createCase")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = CasesResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo createCase(
            @ApiParam(value = "casesRequest") @RequestBody CasesRequest casesRequest) throws MqttException {
        return caseService.createCase(casesRequest);
    }
}
