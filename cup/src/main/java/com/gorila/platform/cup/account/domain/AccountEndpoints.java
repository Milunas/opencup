package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class AccountEndpoints {

    @Autowired
    private AccountService service;

    @PostMapping("/login")
    ResponseEntity<Void> login(Account account){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Localization", account.getId().toString());
        headers.add("Authorization", service.loginAccount(account));
        return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    ResponseEntity<Void> register(Account account){
        HttpHeaders headers = new HttpHeaders();
        Account savedAccount = service.addAccount(account);
        headers.add("Localization", savedAccount.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/account/{accountId}/competitor")
    ResponseEntity<Competitor> competitorByAccountId(@PathVariable Long accountId){
        Competitor databaseCompetitor = service.getCompetitorIdByAccountId(accountId);
        return new ResponseEntity<>(databaseCompetitor, HttpStatus.OK);
    }


}
