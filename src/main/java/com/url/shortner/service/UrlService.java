package com.url.shortner.service;

import com.url.shortner.dto.UrlRequestDto;
import com.url.shortner.dto.UrlResponseDto;
import com.url.shortner.entity.UrlEntity;
import com.url.shortner.repository.UrlRepository;
import com.url.shortner.util.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final UrlUtils urlUtils;

    //validate url
    //shorten url
    //save url to db
    //return url

    public UrlResponseDto shortenUrl(UrlRequestDto urlRequestDto) {
        String url = urlRequestDto.getUrl();
        //logic for validating url
        try{

            boolean isValid = urlUtils.isValid(url);
            if(!isValid){
                throw new RuntimeException("Invalid URL");
            }

            String shortenUrl = RandomStringUtils.randomAlphanumeric(8);
//        if(urlRepository.existsByShortUrl(shortenUrl)){
//            shortenUrl = RandomStringUtils.randomAlphanumeric(8);
//        }

            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortUrl(shortenUrl);
            urlRepository.save(urlEntity);

            return UrlResponseDto.builder()
                    .shortUrl(shortenUrl)
                    .build();

        }
        catch(DataIntegrityViolationException e){
            String shortenUrl = RandomStringUtils.randomAlphanumeric(8);
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortUrl(shortenUrl);
            urlRepository.save(urlEntity);

            return UrlResponseDto.builder()
                    .shortUrl(shortenUrl)
                    .build();

        }
    }

    public URI getRedirectUrl(String shortUrl) {
        String urlToBeParsed= urlRepository.findByShortUrl(shortUrl)
                .map(UrlEntity::getMainUrl)
                .orElse("/");
        return URI.create(urlToBeParsed);

    }


}
