package ru.sharova.pastebox.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sharova.pastebox.api.request.PasteboxRequest;
import ru.sharova.pastebox.api.response.PasteboxResponse;
import ru.sharova.pastebox.api.response.PasteboxUrlResponse;
import ru.sharova.pastebox.service.PasteboxServiceImpl;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
public class PasteboxController {
    private final PasteboxServiceImpl service;

    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash){
        return service.getByHash(hash);
    }

    @GetMapping("/")
    public Collection<PasteboxResponse> getPublicPasteList(){
        return service.getFirstPublicPasteboxes();
    }

    @PostMapping("/")
    public PasteboxUrlResponse add(@RequestBody PasteboxRequest request){
        return service.create(request);
    }
}
