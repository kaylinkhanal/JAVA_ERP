package com.laconic.cb.service.impl;

import com.laconic.cb.model.SecurityBox;
import com.laconic.cb.repository.ISecurityBoxRepository;
import com.laconic.cb.service.ISecurityBoxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityBoxService implements ISecurityBoxService {

    private final ISecurityBoxRepository securityBoxRepository;

    public SecurityBoxService(ISecurityBoxRepository securityBoxRepository) {
        this.securityBoxRepository = securityBoxRepository;
    }

    @Override
    public List<SecurityBox> getSecurityBoxList() {
        return securityBoxRepository.findAll();
    }
}
