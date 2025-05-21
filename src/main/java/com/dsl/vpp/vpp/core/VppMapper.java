package com.dsl.vpp.vpp.core;

import com.dsl.vpp.vpp.core.dto.request.VppCreateRequestDto;
import com.dsl.vpp.vpp.core.dto.VppReadResponseDto;
import com.dsl.vpp.vpp.core.value.VppInfo;

public class VppMapper {
    public static VppInfo mapToValue(VppCreateRequestDto vppCreateRequest) {
        return VppInfo.builder()
                .id(vppCreateRequest.getId())
                .build();
    }

    public static VppInfo mapToValue(VppEntity vppEntity) {
        return VppInfo.builder()
                .id(vppEntity.getId())
                .build();
    }

    public static VppEntity mapToEntity(VppInfo vpp) {
        return VppEntity.builder()
                .id(vpp.getId())
                .build();
    }

    public static VppReadResponseDto mapToDto(VppInfo vpp) {
        return VppReadResponseDto.builder()
                .id(vpp.getId())
                .build();
    }
}