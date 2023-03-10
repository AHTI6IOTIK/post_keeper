package com.example.post_keeper.controller;

import com.example.post_keeper.app.dto.HistoryTypeDto;
import com.example.post_keeper.app.mapper.HistoryTypeMapper;
import com.example.post_keeper.app.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@Tag(name = "History")
@RequestMapping("/api/history")
public class HistoryController {
    private final HistoryService service;
    private final HistoryTypeMapper historyTypeMapper;

    public HistoryController(
        HistoryService service,
        HistoryTypeMapper historyTypeMapper
    ) {
        this.service = service;
        this.historyTypeMapper = historyTypeMapper;
    }

    @GetMapping("/type")
    @Operation(
        summary = "Get all history types"
    )
    public ResponseEntity<List<HistoryTypeDto>> processHistoryType() {
        return ResponseEntity.ok(historyTypeMapper.toDtoList(service.getHistoryTypes()));
    }

    @PostMapping("/type")
    @Operation(
        summary = "Create or update history type"
    )
    public void processHistoryType(
        @Valid @RequestBody List<HistoryTypeDto> historyTypes,
        HttpServletResponse response
    ) {
        service.processHistoryType(historyTypeMapper.toModelList(historyTypes));
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
