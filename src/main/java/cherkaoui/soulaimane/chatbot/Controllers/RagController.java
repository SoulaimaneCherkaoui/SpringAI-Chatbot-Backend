package cherkaoui.soulaimane.chatbot.Controllers;

import cherkaoui.soulaimane.chatbot.services.RagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class RagController {

    private final RagService ragService;

    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @GetMapping("/rag")
    public String rag(@RequestParam String query) {
        return ragService.askllm(query);
    }

    @PostMapping("/addPdf")
    public void addPdf(@RequestBody Resource[] pdfs) {
        ragService.textEmbedding(pdfs);
    }

}

