package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
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
    public void shouldFindAll() {
        // TODO not necessary to test, added for demo purposes
        List<Account> allAccounts = accountRepository.findAll();
        assertThat(allAccounts.size()).isGreaterThan(0);
    }
}
