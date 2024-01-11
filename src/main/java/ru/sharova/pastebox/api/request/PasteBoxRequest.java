package ru.sharova.pastebox.api.request;

import lombok.Data;

@Data
public class PasteBoxRequest {
    private String data;
    private long expretionTimeSeconds;
    private PublicStatus publicStatus;
}
