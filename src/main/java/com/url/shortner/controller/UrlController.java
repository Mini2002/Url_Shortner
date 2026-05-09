package com.url.shortner.controller;

import com.url.shortner.dto.UrlRequestDto;
import com.url.shortner.dto.UrlResponseDto;
import com.url.shortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public UrlResponseDto shorten(@RequestBody UrlRequestDto urlRequestDto) {
        return urlService.shortenUrl(urlRequestDto);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY.value())
                .location(urlService.getRedirectUrl(shortUrl))
                .build();

    }

}
