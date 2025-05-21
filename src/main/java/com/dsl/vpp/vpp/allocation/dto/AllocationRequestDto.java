package com.dsl.vpp.vpp.allocation.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllocationRequestDto {
    String id;
    String derId;
}
