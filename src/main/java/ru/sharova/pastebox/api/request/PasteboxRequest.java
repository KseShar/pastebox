package ru.sharova.pastebox.api.request;

import lombok.Data;

@Data
public class PasteboxRequest {
    private String data;
    private long expretionTimeSeconds;
    private PublicStatus publicStatus;
}
