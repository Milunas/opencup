package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @TestConfiguration
    static class ServiceContextConfiguration{
        @Bean
        AccountService accountService(){
            return new AccountService();
        }
    }

    @Before
    public void setUp(){
        Account account = new Account();
        account.setId(1L);
        account.setEmail("lukas@gmail.com");
        account.setPassword("PASS");

        Competitor competitor = new Competitor();
        competitor.setAccount(account);

        Mockito.when(accountRepository.findById(1L))
                .thenReturn(Optional.ofNullable(account));
    }

    @Test
    public void shouldGetAccount(){
        System.out.println(accountService.getAccount(1L));
    }

    @Test
    public void shouldLogin(){
        Account account = accountService.getAccount(1L);
        System.out.println(accountService.loginAccount(account));
    }

    @Test
    public void shouldReturnCompetitorByAccountId(){
        System.out.println(accountService.getCompetitorIdByAccountId(1L));
    }

}
