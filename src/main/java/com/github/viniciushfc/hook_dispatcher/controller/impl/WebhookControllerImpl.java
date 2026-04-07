package com.github.viniciushfc.hook_dispatcher.controller.impl;

import com.github.viniciushfc.hook_dispatcher.controller.contract.IWebhookController;
import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;
import com.github.viniciushfc.hook_dispatcher.service.impl.WebhookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/webhook")
public class WebhookControllerImpl implements IWebhookController {

    private final WebhookServiceImpl webhookService;

    @GetMapping
    public ResponseEntity<List<WebhookResponse>> findAll() {
        return new ResponseEntity<>(webhookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<WebhookResponse> save(@RequestBody @Valid WebhookRequest request) {
        return new ResponseEntity<>(webhookService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{idWebhook}")
    public ResponseEntity<WebhookResponse> update(@PathVariable UUID idWebhook, @RequestBody @Valid WebhookRequest request) {
        return new ResponseEntity<>(webhookService.update(idWebhook, request), HttpStatus.OK);
    }

    @PatchMapping("/deactivate/{idWebhook}")
    public ResponseEntity<String> deactivate(@PathVariable UUID idWebhook) {
        webhookService.deactivateWebhook(idWebhook);
        return new ResponseEntity<>("Webhook deactivated successfully", HttpStatus.OK);
    }
}
