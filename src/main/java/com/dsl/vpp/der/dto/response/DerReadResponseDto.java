package com.dsl.vpp.der.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DerReadResponseDto {
    String id;
    String vppId;
    Double capacity;
}
