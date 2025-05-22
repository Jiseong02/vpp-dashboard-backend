package com.dsl.vpp.vpp.allocation;

import com.dsl.vpp.vpp.allocation.value.AllocationInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllocationMapper {
    public static AllocationInfo mapToValue(String id, String derId) {
        return AllocationInfo.builder()
                .vppId(id)
                .derId(derId)
                .build();
    }
}
