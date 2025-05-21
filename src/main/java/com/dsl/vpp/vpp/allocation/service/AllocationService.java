package com.dsl.vpp.vpp.allocation.service;

import com.dsl.vpp.vpp.allocation.value.AllocationInfo;

public interface AllocationService {
    void allocate(AllocationInfo allocation);
    void deallocate(AllocationInfo allocation);
}
