package com.sleeksys.datalog.repository;

import com.sleeksys.datalog.model.Log;
import com.sleeksys.datalog.model.LogType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    List<Log> findByType(LogType type);
    List<Log> findByHost(String host);
    List<Log> findBySource(String source);
    List<Log> findByMethod(String method);

    @Query(value = "{'date': {$gte: ?0, $lte:?1 }}", sort = "{'date' : -1}")
    List<Log> findByPeriod(Date start, Date end);

    Optional<Log> findById(String id);
}
