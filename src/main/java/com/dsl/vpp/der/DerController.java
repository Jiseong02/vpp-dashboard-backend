package com.dsl.vpp.der;

import com.dsl.vpp.der.dto.request.DerCreateRequestDto;
import com.dsl.vpp.der.dto.response.DerReadListResponseDto;
import com.dsl.vpp.der.dto.response.DerReadResponseDto;
import com.dsl.vpp.der.service.DerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DerController {
    DerService derService;

    @Autowired
    DerController(DerService derService) {
        this.derService = derService;
    }

    @PostMapping("/ders")
    ResponseEntity<String> create(@Valid @RequestBody DerCreateRequestDto createRequestDto) {
        return ResponseEntity.ok().body(derService.create(DerMapper.mapToValue(createRequestDto)));
    }

    @GetMapping("/ders")
    ResponseEntity<DerReadListResponseDto> read() {
        return ResponseEntity.ok().body(DerMapper.mapToDto(derService.readAll()));
    }

    @GetMapping("/ders/{id}")
    ResponseEntity<DerReadResponseDto> read(@PathVariable String id) {
        return ResponseEntity.ok().body(DerMapper.mapToDto(derService.readById(id)));
    }

    @GetMapping("/vpps/{vppId}/ders")
    ResponseEntity<DerReadListResponseDto> readByVppId(@PathVariable String vppId) {
        return ResponseEntity.ok().body(DerMapper.mapToDto(derService.readByVppId(vppId)));
    }

    @DeleteMapping("/ders/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        derService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
