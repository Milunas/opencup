package com.gorila.platform.cup.competitor.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

    @Query(value = "SELECT * FROM competitor " +
            "WHERE competitor.account_id = :accountId", nativeQuery = true)
    Optional<Competitor> findCompetitorByAccountId(@Param("accountId") Long accountId);

    @Query(value = "SELECT * FROM competitor " +
            "WHERE competitor.weight BETWEEN :value1 AND :value2 " +
            "AND competitor.belt = :belt", nativeQuery = true)
    Set<Competitor> findCompetitorsByCategory(@Param("value1") Integer value1, @Param("value2") Integer value2, @Param("belt") CompetitorBelt belt);
}
