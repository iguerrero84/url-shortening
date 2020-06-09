package com.example.urlShortening.services;

import com.example.urlShortening.entities.ShortenUrl;

import java.util.Optional;

/**
 * @author Israel Guerrero
 */
public interface ShortenUrlService {

    String shortenUrl(String originalUrl);

    Optional<ShortenUrl> getShortenUrl(String shortenKey);

}
