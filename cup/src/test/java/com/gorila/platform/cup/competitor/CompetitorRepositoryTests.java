package com.gorila.platform.cup.competitor;

import com.gorila.platform.cup.account.domain.Account;
import com.gorila.platform.cup.competitor.domain.Competitor;
import com.gorila.platform.cup.competitor.domain.CompetitorBelt;
import com.gorila.platform.cup.competitor.domain.CompetitorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompetitorRepositoryTests {

    @Autowired
    private CompetitorRepository competitorRepository;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp(){
        Account account = new Account();
        account.setEmail("aaa@gmail.com");

        Competitor competitor = new Competitor();
        competitor.setFirstName("Lukas");
        competitor.setWeight(70);
        competitor.setBelt(CompetitorBelt.BROWN);
        competitor.setAccount(account);

        entityManager.persist(competitor);
        entityManager.flush();
    }

    @Test
    public void shouldReturnCompetitorByAccountId(){
        System.out.println(competitorRepository.findCompetitorByAccountId(1L));
    }

    @Test
    public void shouldReturnSetUpCompetitor() {
        System.out.println(competitorRepository.findCompetitorsByCategory(65, 75, CompetitorBelt.BROWN));
    }

}
