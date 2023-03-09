package com.example.post_keeper.controller;

import com.example.post_keeper.app.dto.PostOfficeDto;
import com.example.post_keeper.app.mapper.PostOfficeMapper;
import com.example.post_keeper.app.service.PostOfficeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@Tag(name = "Post")
@RequestMapping("/api/post_office")
public class PostOfficeController {
    private final PostOfficeService service;
    private final PostOfficeMapper postOfficeMapper;

    public PostOfficeController(
        PostOfficeService service,
        PostOfficeMapper postOfficeMapper
    ) {
        this.service = service;
        this.postOfficeMapper = postOfficeMapper;
    }

    @GetMapping
    @Operation(
        summary = "Get all post offices"
    )
    public ResponseEntity<List<PostOfficeDto>> processShipmentType() {
        return ResponseEntity.ok(postOfficeMapper.toDtoList(service.getOffices()));
    }

    @PostMapping
    @Operation(
        summary = "Create or update post offices"
    )
    public void processShipmentType(
        @Valid @RequestBody List<PostOfficeDto> postOffices,
        HttpServletResponse response
    ) {
        service.processPostOffices(postOfficeMapper.toModelList(postOffices));
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
