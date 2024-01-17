package ru.sharova.pastebox.service;

import ru.sharova.pastebox.api.request.PasteboxRequest;
import ru.sharova.pastebox.api.response.PasteboxResponse;
import ru.sharova.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPasteboxes();
    PasteboxUrlResponse create(PasteboxRequest request);
}
