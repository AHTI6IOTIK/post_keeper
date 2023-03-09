package com.example.post_keeper.app.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ShipmentStatusDto {
    private String shipmentType;

    private int recipientZipcode;

    private String recipientAddress;

    private String recipientName;

    private List<MovingHistoryDto> historyList;
}
