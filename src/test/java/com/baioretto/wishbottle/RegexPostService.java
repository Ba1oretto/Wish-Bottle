package com.baioretto.wishbottle;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NewClassNamingConvention")
public class RegexPostService {

    @Test
    void checkBase64Format() {
        System.out.println("sss.JPG".matches("^.+\\.(?i)(jpg|png|jpeg|jfif)$"));
    }
}
