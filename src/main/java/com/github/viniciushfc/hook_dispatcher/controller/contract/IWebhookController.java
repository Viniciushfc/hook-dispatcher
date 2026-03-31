package com.github.viniciushfc.hook_dispatcher.controller.contract;

import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IWebhookController {

    ResponseEntity<List<WebhookResponse>> findAll();

    ResponseEntity<WebhookResponse> save(WebhookRequest request);

    ResponseEntity<WebhookResponse> update(UUID idWebhook, WebhookRequest request);

    ResponseEntity<String> deactivate(WebhookRequest request);
}
