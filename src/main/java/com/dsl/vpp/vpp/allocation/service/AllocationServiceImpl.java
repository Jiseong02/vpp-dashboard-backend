package com.dsl.vpp.vpp.allocation.service;

import com.dsl.vpp.der.service.DerService;
import com.dsl.vpp.vpp.core.service.VppService;
import com.dsl.vpp.vpp.allocation.value.AllocationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationServiceImpl implements AllocationService {
    VppService vppService;
    DerService derService;

    @Autowired
    AllocationServiceImpl(VppService vppService, DerService derService) {
        this.vppService = vppService;
        this.derService = derService;
    }

    @Override
    public void allocate(AllocationInfo allocation) {
        vppService.validateIdExists(allocation.getVppId());
        derService.register(allocation.getDerId(), allocation.getVppId());
    }

    @Override
    public void deallocate(AllocationInfo allocation) {
        vppService.validateIdExists(allocation.getVppId());
        derService.unregister(allocation.getDerId());
    }
}
