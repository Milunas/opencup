package com.gorila.platform.cup.account.domain;

import com.gorila.platform.cup.competitor.domain.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
interface AccountRepository extends JpaRepository<Account, Long> {

}
