package com.sleeksys.datalog.repository;

import com.sleeksys.datalog.model.Log;
import com.sleeksys.datalog.model.LogType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    List<Log> findByType(LogType type);
    List<Log> findByHost(String host);
    List<Log> findBySource(String source);
    List<Log> findByMethod(String method);
    Optional<Log> findById(String id);
}
