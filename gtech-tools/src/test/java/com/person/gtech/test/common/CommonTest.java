package com.person.gtech.test.common;

import com.person.gtech.GtechToolApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 彭心潮
 * @date 2022/11/6 21:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {GtechToolApplication.class})
public class CommonTest {

    @Test
    public void startTest() {
        Assert.assertTrue(true);
    }
}
