package com.laconic.cb.service;

import com.laconic.cb.model.SecurityBox;

import java.util.List;
import java.util.Optional;

public interface ISecurityBoxService {
    List<SecurityBox> getSecurityBoxList();
    Optional<SecurityBox> findById(Long securityBoxId);
}
