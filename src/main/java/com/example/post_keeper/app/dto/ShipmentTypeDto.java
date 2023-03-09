package com.example.post_keeper.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShipmentTypeDto {
    private Long id;

    @NotNull
    @NotBlank
    private String name;
}
