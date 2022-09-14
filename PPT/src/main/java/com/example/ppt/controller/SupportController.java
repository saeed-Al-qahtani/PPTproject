package com.example.ppt.controller;

import com.example.ppt.Dto.ApiResponse;
import com.example.ppt.model.Support;
import com.example.ppt.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping("/api/v1/support")
@RestController
@RequiredArgsConstructor
public class SupportController {
    private final SupportService supportService;

    @GetMapping
    public ResponseEntity getSupport() {
        return ResponseEntity.status(200).body(supportService.getSupport());
    }

    @PostMapping("/addS")
    public ResponseEntity setSupport(@RequestBody @Valid Support support) {
        supportService.setSupport(support);
        return ResponseEntity.status(201).body(new ApiResponse("Support added", 201));

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Support> getSupportById(@PathVariable @Valid Integer id){
        Support support=supportService.getSupportById(id);
        return ResponseEntity.status(200).body(support);
    }

}
