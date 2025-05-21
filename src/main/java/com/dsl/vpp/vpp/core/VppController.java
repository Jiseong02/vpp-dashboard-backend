package com.dsl.vpp.vpp.core;

import com.dsl.vpp.vpp.allocation.AllocationMapper;
import com.dsl.vpp.vpp.allocation.service.AllocationService;
import com.dsl.vpp.vpp.allocation.dto.AllocationRequestDto;
import com.dsl.vpp.vpp.allocation.dto.DeallocationRequestDto;
import com.dsl.vpp.vpp.core.dto.request.VppCreateRequestDto;
import com.dsl.vpp.vpp.core.dto.VppReadResponseDto;
import com.dsl.vpp.vpp.core.service.VppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VppController {
    VppService vppService;
    AllocationService allocationService;

    @Autowired
    VppController(VppService vppService, AllocationService allocationService) {
        this.vppService = vppService;
        this.allocationService = allocationService;
    }

    @PostMapping("/vpps")
    ResponseEntity<String> create(@RequestBody VppCreateRequestDto vppCreateRequest) {
        return ResponseEntity.ok().body(vppService.create(VppMapper.mapToValue(vppCreateRequest)));
    }
    @GetMapping("/vpps/{id}")
    ResponseEntity<VppReadResponseDto> read(@PathVariable String id) {
        return ResponseEntity.ok().body(VppMapper.mapToDto(vppService.readById(id)));
    }

    @PostMapping("/vpps/{id}/ders/{id}")
    ResponseEntity<Void> allocateDer(@RequestBody AllocationRequestDto vppAllocateDerRequest) {
        allocationService.allocate(AllocationMapper.mapToValue(vppAllocateDerRequest));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/vpps/{id}/ders/{id}")
    ResponseEntity<Void> deallocateDer(@RequestBody DeallocationRequestDto vppDeallocateDerRequest) {
        allocationService.deallocate(AllocationMapper.mapToValue(vppDeallocateDerRequest));
        return ResponseEntity.ok().build();
    }
}
