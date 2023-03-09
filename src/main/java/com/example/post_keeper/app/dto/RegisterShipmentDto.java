package com.example.post_keeper.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterShipmentDto {
    @NotNull
    @Positive
    private Long historyType;

    @NotNull
    @Positive
    private Long postOffice;

    @NotNull
    @Positive
    private Long shipmentType;

    @NotNull
    @Positive
    private int recipientZipcode;

    @NotNull
    @NotBlank
    private String recipientAddress;

    @NotNull
    @NotBlank
    private String recipientName;
}
