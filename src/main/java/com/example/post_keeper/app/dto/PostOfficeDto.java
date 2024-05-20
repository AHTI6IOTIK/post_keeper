package com.example.post_keeper.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostOfficeDto {
    private Long id;

    @Positive
    private int zipcode;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

}
