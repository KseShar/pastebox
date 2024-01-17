package ru.sharova.pastebox.repository;

import lombok.Data;
import ru.sharova.pastebox.api.request.PublicStatus;

import java.time.LocalDateTime;
@Data
public class PasteboxEntity {
    private int id;
    private String data;
    private boolean isPublic;
    private LocalDateTime lifeTime;
    private String hash;
}
