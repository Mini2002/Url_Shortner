package com.url.shortner.repository;

import com.url.shortner.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity,Long> {
//         boolean existsByShortUrl(String shortUrl);
    Optional<UrlEntity> findByShortUrl(String shortUrl);
}
