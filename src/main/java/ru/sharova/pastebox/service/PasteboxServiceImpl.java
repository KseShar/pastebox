package ru.sharova.pastebox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sharova.pastebox.api.request.PasteboxRequest;
import ru.sharova.pastebox.api.request.PublicStatus;
import ru.sharova.pastebox.api.response.PasteboxResponse;
import ru.sharova.pastebox.api.response.PasteboxUrlResponse;
import ru.sharova.pastebox.repository.PasteboxEntity;
import ru.sharova.pastebox.repository.PasteboxRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
//@Configuration
@RequiredArgsConstructor
//@ConfigurationProperties(prefix = "app")
//@ConstructorBinding
//@Component
public class PasteboxServiceImpl implements PasteboxService{
 /*   @Value("${app.host}")*/
    private String host = "http://abc.ru";
   // @Value("${app.publicListSize}")
    private int publicListSize = 10;
    private final PasteboxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);
    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity pasteboxEntity = repository.getByHash(hash);
        return new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic());
    }
    @Override
    public List<PasteboxResponse> getFirstPublicPasteboxes() {
        List<PasteboxEntity> list = repository.getListOfPublicAndAlive(publicListSize);
        return list.stream().map(pasteboxEntity -> new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic()))
                .collect(Collectors.toList());
    }
    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        int hash = generateId();
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setData(request.getData());
        pasteboxEntity.setId(hash);
        pasteboxEntity.setHash(Integer.toHexString(hash));
        pasteboxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteboxEntity.setLifeTime(LocalDateTime.now().plusSeconds(request.getExpretionTimeSeconds()));
        repository.add(pasteboxEntity);
        return new PasteboxUrlResponse(host + "/" + pasteboxEntity.getHash());
    }

    private int generateId(){
        return idGenerator.getAndIncrement();
    }
}
