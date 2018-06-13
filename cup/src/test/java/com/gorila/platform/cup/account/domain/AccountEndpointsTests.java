package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.CupApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CupApplication.class)
public class AccountEndpointsTests {

    @LocalServerPort
    private Integer port;
    @Autowired
    private AccountEndpoints accountEndpoints;

    @Before
    public void setUp(){
        Account account = new Account();
        accountEndpoints.register(account);
    }

    @Test
    public void shouldGetExampleMovieByTitle(){
        given()
                .port(port)
        .when()
                .get("/login")
        .then()
                .assertThat()
                    .statusCode(200)
                    .body("", is(""));
    }

}
