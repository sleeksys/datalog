package com.sleeksys.datalog.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@Document("all_logs")
public class Log {

    @Id
    private String id;

    private Date date;

    @Field(value = "log_type")
    private LogType type;

    private String host;

    private String source;

    private String method;

    private String message;
}
