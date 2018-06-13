package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp(){
        Account account = new Account();
        account.setEmail("aaa@gmail.com");

        Competitor competitor = new Competitor();
        competitor.setFirstName("Lukas");
        competitor.setAccount(account);

        entityManager.persist(competitor);
        entityManager.flush();
    }

    @Test
    public void shouldReturnAccountJoinedWithCompetitor(){
        System.out.println(accountRepository.findCompetitorByAccountId(1L));
    }
}
