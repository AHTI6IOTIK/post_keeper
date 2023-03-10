package com.example.post_keeper.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HistoryTypeDto {
    private Long id;

    @NotNull
    @NotBlank
    private String name;
}
