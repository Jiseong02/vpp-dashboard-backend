package com.dsl.vpp.der.value;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DerInfo {
    String id;
    String vppId;
    Double capacity;
}
