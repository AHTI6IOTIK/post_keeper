package com.example.post_keeper.app.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
public class MovingHistoryDto {
    private LocalDateTime date;

    private String type;

    private PostOfficeDto postOffice;
}
