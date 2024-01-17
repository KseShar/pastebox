package ru.sharova.pastebox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.sharova.pastebox.api.response.PasteboxResponse;
import ru.sharova.pastebox.exception.NotFoundEntityException;
import ru.sharova.pastebox.repository.PasteboxEntity;
import ru.sharova.pastebox.repository.PasteboxRepository;
import ru.sharova.pastebox.service.PasteboxService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteboxServiceTest {
    @Autowired
    private PasteboxService service;
    @MockBean
    private PasteboxRepository repository;
    @Test
    public void notExistHash(){
        when(repository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> service.getByHash("dfhdhd3"));
    }

    @Test
    public void getExistHash(){
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setHash("1");
        pasteboxEntity.setData("11");
        pasteboxEntity.setPublic(true);

        when(repository.getByHash("1")).thenReturn(pasteboxEntity);

        PasteboxResponse expected = new PasteboxResponse("11", true);
        PasteboxResponse actual = service.getByHash("1");

        assertEquals(expected, actual);
    }
}
