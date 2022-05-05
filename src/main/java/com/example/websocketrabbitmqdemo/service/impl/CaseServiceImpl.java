package com.example.websocketrabbitmqdemo.service.impl;

import com.example.websocketrabbitmqdemo.dto.request.cases.CasesRequest;
import com.example.websocketrabbitmqdemo.service.CaseService;
import com.example.websocketrabbitmqdemo.utils.responseinfo.ResponseInfo;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl implements CaseService {

    @Override
    public ResponseInfo createCase(CasesRequest caseRequest) {
        return null;
    }
}
