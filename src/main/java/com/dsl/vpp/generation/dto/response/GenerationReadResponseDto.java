package com.dsl.vpp.generation.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GenerationReadResponseDto {
    String id;
    String derId;
    Double amount;
    LocalDateTime dateTime;
}
