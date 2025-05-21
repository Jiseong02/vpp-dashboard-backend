package com.dsl.vpp.generation.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class GenerationReadRequestDto {
    String derId;
    String vppId;
    LocalDate startDate;
    LocalDate endDate;
}
