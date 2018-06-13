package com.gorila.platform.cup.competitor.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/competitor")
class CompetitorEndpoints {

    @Autowired
    private CompetitorService competitorService;

    @GetMapping("/account/{accountId}")
    ResponseEntity<Competitor> getCompetitorByAccountId(@PathVariable Long accountId){
        Competitor databaseCompetitor = competitorService.getCompetitorByAccountId(accountId);
        return new ResponseEntity<>(databaseCompetitor, HttpStatus.ACCEPTED);
    }

    @PostMapping("/account/{accountId}")
    ResponseEntity<Void> addCompetitorToExistingAccount(@PathVariable Long accountId){
        HttpHeaders headers = new HttpHeaders();
        Long createdCompetitorId = competitorService.addCompetitorToExistingAccount(accountId).getId();
        headers.add("Localization", createdCompetitorId.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<Collection<Competitor>> getAllCompetitors(){
        return new ResponseEntity<>(competitorService.getAllCompetitors(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{competitorId}") // TODO capability to edit existing competitor
    public void editCompetitor(@RequestBody Competitor competitor){
    }

    @GetMapping("/category")
    public Collection<Competitor> getCompetitorCategory(@Param("from") Integer minWeight,
                                                        @Param("to") Integer maxWeight,
                                                        @Param("belt") CompetitorBelt belt){
        return competitorService.getCompetitorsByCategory(minWeight, maxWeight, belt);
    }
}
