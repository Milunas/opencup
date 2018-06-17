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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
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
        Optional<Competitor> competitor = competitorRepository.findCompetitorByAccountId(1L);
        assertThat(competitor.isPresent()).isTrue();
    }

    @Test
    public void shouldReturnSetUpCompetitor() {
        System.out.println(competitorRepository.findCompetitorsByCategory(65, 75, CompetitorBelt.BROWN));
    }

    @Test
    public void shouldFindCompetitorByAccountEmail(){
        assertThat(competitorRepository.findByAccountEmail("aaa@gmail.com")).isNotNull();
    }
}
