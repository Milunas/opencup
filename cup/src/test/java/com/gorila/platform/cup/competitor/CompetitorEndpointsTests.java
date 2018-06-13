package com.gorila.platform.cup.competitor;

import com.gorila.platform.cup.CupApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CupApplication.class)
public class CompetitorEndpointsTests {
}
