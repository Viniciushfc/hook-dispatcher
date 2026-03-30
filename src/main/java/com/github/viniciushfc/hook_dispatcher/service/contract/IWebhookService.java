package com.github.viniciushfc.hook_dispatcher.service.contract;

import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;

import java.util.UUID;

public interface IWebhookService {

    WebhookResponse save(WebhookRequest request);

    WebhookResponse update(UUID idWebhook, WebhookRequest request);

    void deactivateWebhook(UUID idWebhook);
}
