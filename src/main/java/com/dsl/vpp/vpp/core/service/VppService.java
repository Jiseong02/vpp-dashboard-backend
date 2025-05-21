package com.dsl.vpp.vpp.core.service;

import com.dsl.vpp.vpp.core.value.VppInfo;

public interface VppService {
    String create(VppInfo vpp);
    VppInfo readById(String id);
    void deleteById(String id);

    void validateIdNotExists(String id);
    void validateIdExists(String id);
}
