package ru.sharova.pastebox.controllers;

import org.springframework.web.bind.annotation.*;
import ru.sharova.pastebox.api.request.PasteBoxRequest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class PasteBoxController {
    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }

    @GetMapping("/{hash}")
    public Collection<String> getPublicPasteList(@PathVariable String hash){
        return Collections.emptyList();
    }

    @PostMapping("/")
    public String add(@RequestBody PasteBoxRequest request){
        return request.getData();
    }
}
