package com.github.viniciushfc.hook_dispatcher.service.contract;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;
import com.github.viniciushfc.hook_dispatcher.service.generic.contract.IAbstractService;

import java.util.UUID;

public interface IWebhookService extends IAbstractService<Webhook, UUID, WebhookResponse> {

    WebhookResponse save(WebhookRequest request);

    WebhookResponse update(UUID idWebhook, WebhookRequest request);

    void deactivateWebhook(UUID idWebhook);
}
