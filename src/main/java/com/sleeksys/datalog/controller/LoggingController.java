package com.sleeksys.datalog.controller;

import com.sleeksys.datalog.model.Log;
import com.sleeksys.datalog.model.LogType;
import com.sleeksys.datalog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoggingController {

    @Autowired
    private LogService logService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    /**
    @GetMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
     */

    @GetMapping("/logs")
    public List<Log> findAll() {
        return this.logService.findAll();
    }

    @GetMapping("/logs/period")
    public List<Log> findByPeriod(@RequestParam Long start, @RequestParam Long end) {
        return this.logService.findByPeriod(start, end);
    }

    @GetMapping("/logs/custom-period")
    public List<Log> findByCustomPeriod(@RequestParam String period) {
        return this.logService.findByCustomPeriod(period);
    }

    @GetMapping("/logs/type/{type}")
    public List<Log> findByType(@PathVariable LogType type) {
        return this.logService.findByType(type);
    }

    @GetMapping("/logs/host/{id}")
    public List<Log> findByHost(@PathVariable String host) {
        return this.logService.findByHost(host);
    }

    @GetMapping("/logs/source/{id}")
    public List<Log> findBySource(@PathVariable String source) {
        return this.logService.findBySource(source);
    }

    @GetMapping("/logs/method/{method}")
    public List<Log> findByMethod(@PathVariable String method) {
        return this.logService.findByMethod(method);
    }

    @GetMapping("/logs/{id}")
    public Log findById(@PathVariable String id) {
        return this.logService.findById(id);
    }

    @PostMapping("/logs")
    public Log create(@RequestBody Log log) {
        return this.logService.create(log);
    }
}
