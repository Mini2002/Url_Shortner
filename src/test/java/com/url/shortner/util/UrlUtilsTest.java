package com.url.shortner.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UrlUtilsTest {

    private UrlUtils urlUtils;

    @Test
    public void test_isValid(){
        assertTrue(urlUtils.isValid("http://example.com"));
        assertTrue(urlUtils.isValid("https://example.com"));
        assertFalse(urlUtils.isValid("welcome"));
        assertFalse(urlUtils.isValid("htp://example.com"));

    }
}
