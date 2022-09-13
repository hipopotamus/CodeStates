package com.codestates;

import org.assertj.core.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.*;

public class HelloJUnitTest {

    @Test
    public void assertionTest() {
        String expected = "Hello, Junit";
        String actual = "Hello, Junit!";

        assertThat(expected)
                .isNotEqualTo(actual)
                .isNotNull();
    }

    @Test
    public void exceptionTest() {
        assertThatThrownBy(() -> CryptoCurrency.map.get("A").toUpperCase())
                .isInstanceOf(NullPointerException.class);

    }

    public static class CryptoCurrency {
        public static Map<String, String> map = new HashMap<>();

        static {
            map.put("BTC", "Bitcoin");
            map.put("ETH", "Ethereum");
            map.put("ADA", "ADA");
            map.put("POT", "Polkadot");
        }
    }
}
