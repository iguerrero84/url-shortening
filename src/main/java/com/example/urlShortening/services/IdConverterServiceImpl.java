package com.example.urlShortening.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Israel Guerrero
 */
@Service
public class IdConverterServiceImpl implements IdConverterService {

    @Value("${possible.alphabet}")
    private String POSSIBLE_ALPHABET;


    @Value("${alphabet.length}")
    private long BASE;


    /**
     * Function to generate a shortenKey from integer ID
     */
    @Override
    public String encode(long id) {
        StringBuilder shortenKey = new StringBuilder();
        while (id > 0) {
            shortenKey.insert(0, POSSIBLE_ALPHABET.charAt((int) (id % BASE)));
            id = id / BASE;
        }
        return shortenKey.toString();
    }

    /**
     * Function to get integer ID back from a shortenKey
     */
    @Override
    public long decode(String shortenKey) {
        long num = 0;
        for (int i = 0; i < shortenKey.length(); i++) {
            num = num * BASE + POSSIBLE_ALPHABET.indexOf(shortenKey.charAt(i));
        }
        return num;
    }
}
