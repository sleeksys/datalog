package com.sleeksys.datalog.service;

import com.sleeksys.datalog.exception.ResourceNotFoundException;
import com.sleeksys.datalog.model.CustomPeriod;
import com.sleeksys.datalog.model.Log;
import com.sleeksys.datalog.model.LogType;
import com.sleeksys.datalog.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Log> findAll() {
        return this.logRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    public List<Log> findByPeriod(Long start, Long end) {
        return this.findAll()
                .stream()
                .filter(log ->
                        (start <= log.getDate().getTime() && log.getDate().getTime() <= end)
                )
                .collect(Collectors.toList());
    }

    public List<Log> findByCustomPeriod(String period) {
        return this.findByPeriod(
                CustomPeriod.getStartDate(period),
                CustomPeriod.getEndDate());
    }

    public List<Log> findByType(LogType type) {
        return this.logRepository.findByType(type);
    }

    public List<Log> findByHost(String host) {
        return this.logRepository.findByHost(host);
    }

    public List<Log> findBySource(String source) {
        return this.logRepository.findBySource(source);
    }

    public List<Log> findByMethod(String method) {
        return this.logRepository.findByMethod(method);
    }

    public Log findById(String id) {
        Optional<Log> optional = this.logRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new ResourceNotFoundException("Log not found with id " + id);
    }

    public Log create(Log log) {
        log.setDate(new Date());

        return this.logRepository.insert(log);
    }
}
