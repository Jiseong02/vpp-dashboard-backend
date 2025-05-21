package com.dsl.vpp.vpp.allocation.value;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllocationInfo {
    String vppId;
    String derId;
}
