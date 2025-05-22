package com.dsl.vpp.vpp.core.service;

import com.dsl.vpp.vpp.core.value.VppInfo;

import java.util.List;

public interface VppService {
    String create(VppInfo vpp);
    VppInfo readById(String id);
    List<VppInfo> readAll();
    void deleteById(String id);

    void validateIdNotExists(String id);
    void validateIdExists(String id);
}
