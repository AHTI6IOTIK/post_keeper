package com.example.post_keeper.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovingShipmentDto {
    @NotNull
    @Positive
    private Long shipmentId;

    @NotNull
    @Positive
    private Long historyType;

    @NotNull
    @Positive
    private Long postOffice;
}
