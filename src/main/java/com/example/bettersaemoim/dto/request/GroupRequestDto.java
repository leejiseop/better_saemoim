package com.example.bettersaemoim.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequestDto {
    @NotNull
    private String categoryName;

    private List<String> tagNames;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 10, max = 500)
    private String content;

    @NotBlank
    private String address;

    @NotBlank
    private String firstRegion;

    @NotBlank
    private String secondRegion;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @Min(1)
    @Max(100)
    private int recruitNumber;
}
