package com.github.viniciushfc.hook_dispatcher.service.contract;

import com.github.viniciushfc.hook_dispatcher.dtos.WebhookDTO;

import java.util.UUID;

public interface IWebhookService {

    WebhookDTO save(WebhookDTO dto);

    WebhookDTO update(UUID idWebhook, WebhookDTO dto);

    void desativeWebhook(UUID idWebhook);
}
