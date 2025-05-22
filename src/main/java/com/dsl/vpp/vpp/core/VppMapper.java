package com.dsl.vpp.vpp.core;

import com.dsl.vpp.vpp.core.dto.request.VppCreateRequestDto;
import com.dsl.vpp.vpp.core.dto.response.VppReadListResponseDto;
import com.dsl.vpp.vpp.core.dto.response.VppReadResponseDto;
import com.dsl.vpp.vpp.core.value.VppInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<VppInfo> mapToValue(List<VppEntity> vpps) {
        return vpps.stream()
                .map(VppMapper::mapToValue)
                .collect(Collectors.toList());
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

    public static VppReadListResponseDto mapToDto(List<VppInfo> vpps) {
        return VppReadListResponseDto.builder()
                .vpps(vpps.stream()
                        .map(VppMapper::mapToDto)
                        .collect(Collectors.toCollection(ArrayList::new))
                )
                .build();
    }
}