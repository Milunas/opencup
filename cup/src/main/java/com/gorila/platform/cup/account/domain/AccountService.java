package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    String loginAccount(Account account) {
        // TODO implement login access
        Optional<Account> databaseAccount = accountRepository.findById(account.getId());
        return databaseAccount.map(Account::getEmail).orElse("Null");
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).orElse(new Account());
    }

    Competitor getCompetitorIdByAccountId(Long accountId) {
        return accountRepository.findCompetitorByAccountId(accountId)/*.orElse(new Competitor())*/;
    }
}
