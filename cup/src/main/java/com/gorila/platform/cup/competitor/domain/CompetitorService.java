package com.gorila.platform.cup.competitor.domain;

import com.gorila.platform.cup.account.domain.Account;
import com.gorila.platform.cup.account.domain.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
class CompetitorService {

    @Autowired
    private CompetitorRepository competitorRepository;
    @Autowired
    private AccountService accountService;

    Collection<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
    }

    Collection<Competitor> getCompetitorsByCategory(Integer minWeight, Integer maxWeight, CompetitorBelt belt) {
        return competitorRepository.findCompetitorsByCategory(minWeight, maxWeight, belt);
    }

    Competitor getCompetitorByAccountId(Long accountId) {
        return competitorRepository
                .findCompetitorByAccountId(accountId)
                .orElse(new Competitor());
    }

    Competitor addCompetitorToExistingAccount(Long accountId) {
        Account databaseAccount = accountService.getAccount(accountId);
        Competitor createdCompetitor = new Competitor();
        createdCompetitor.setAccount(databaseAccount);
        return competitorRepository.save(createdCompetitor);
    }
}
