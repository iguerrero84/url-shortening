package com.example.urlShortening;

import com.example.urlShortening.services.IdConverterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Israel Guerrero
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IdConverterUnitTest {

    @Autowired
    private IdConverterService idConverterService;

    @Test
    public void success_encode_125_base10_to_base62() {
        String base62Str = idConverterService.encode(125L);
        assertEquals("ba", base62Str);
    }

    @Test
    public void success_encode_19158_base10_to_base62() {
        String s = idConverterService.encode(19168L);
        assertEquals("d8j", s);
    }

    @Test
    public void success_encode_base10_to_base62() {
        assertEquals("aa", idConverterService.encode(63L));
        assertEquals("ab", idConverterService.encode(64L));
        assertEquals("ac", idConverterService.encode(65L));
        assertEquals("a8", idConverterService.encode(123L));
        assertEquals("bb", idConverterService.encode(126L));
        assertEquals("ca", idConverterService.encode(187L));
    }

    @Test
    public void success_decode_base62_to_base10() {
        long i = idConverterService.decode("ba");
        assertEquals(125L, i);
        long j = idConverterService.decode("d8j");
        assertEquals(19168L, j);
    }
}
