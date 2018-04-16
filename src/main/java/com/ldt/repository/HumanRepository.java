package com.ldt.repository;

import com.ldt.dto.Human;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by Ludovic on 16/04/2018.
 */
public interface HumanRepository extends Neo4jRepository<Human, Long> {

    Human findByName(@Param("name") String name);

    Collection<Human> findByNameLike(@Param("name") String name);

    @Query("MATCH (h:Human)<-[r:FRIEND]-(a:Human) RETURN h,r,a LIMIT {limit}")
    Collection<Human> graph(@Param("limit") int limit);
}
