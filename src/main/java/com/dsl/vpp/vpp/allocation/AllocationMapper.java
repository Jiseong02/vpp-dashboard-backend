package com.dsl.vpp.vpp.allocation;

import com.dsl.vpp.vpp.allocation.dto.AllocationRequestDto;
import com.dsl.vpp.vpp.allocation.dto.DeallocationRequestDto;
import com.dsl.vpp.vpp.allocation.value.AllocationInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllocationMapper {
    public static AllocationInfo mapToValue(AllocationRequestDto allocateDerRequestDto) {
        return AllocationInfo.builder()
                .vppId(allocateDerRequestDto.getId())
                .derId(allocateDerRequestDto.getDerId())
                .build();
    }
    public static AllocationInfo mapToValue(DeallocationRequestDto deallocateDerRequestDto) {
        return AllocationInfo.builder()
                .derId(deallocateDerRequestDto.getDerId())
                .build();
    }
}
