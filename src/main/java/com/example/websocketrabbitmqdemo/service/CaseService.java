package com.example.websocketrabbitmqdemo.service;

import com.example.websocketrabbitmqdemo.dto.request.cases.CasesRequest;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;

public interface CaseService {

    public ResponseInfo createCase(CasesRequest caseRequest);
}
