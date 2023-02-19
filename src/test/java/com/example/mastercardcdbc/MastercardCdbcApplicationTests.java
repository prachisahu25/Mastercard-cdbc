package com.example.mastercardcdbc;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MastercardCdbcApplicationTests {

    @Test(expected = Test.None.class)
    public void contextLoads() {
    }
}
