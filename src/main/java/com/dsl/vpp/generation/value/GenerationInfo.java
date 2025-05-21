package com.dsl.vpp.generation.value;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GenerationInfo {
    String id;
    String derId;
    Double amount;
    LocalDateTime dateTime;
}
