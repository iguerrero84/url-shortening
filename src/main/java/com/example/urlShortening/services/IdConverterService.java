package com.example.urlShortening.services;

/**
 * @author Israel Guerrero
 */
public interface IdConverterService {

    String encode(long num);

    long decode(String shortenKey);
}
