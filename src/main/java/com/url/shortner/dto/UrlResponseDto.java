package com.url.shortner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Builder
public class UrlResponseDto {

    private String shortUrl;
}
