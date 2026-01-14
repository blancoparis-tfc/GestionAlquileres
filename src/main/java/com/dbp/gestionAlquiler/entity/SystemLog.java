package com.dbp.gestionAlquiler.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SystemLog {
    private Long id;
    private LocalDateTime timestamp;
}
