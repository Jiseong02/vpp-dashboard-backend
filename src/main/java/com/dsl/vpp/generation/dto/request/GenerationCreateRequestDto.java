package com.dsl.vpp.generation.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GenerationCreateRequestDto {
    String derId;
    Double amount;
    LocalDateTime dateTime;
}
