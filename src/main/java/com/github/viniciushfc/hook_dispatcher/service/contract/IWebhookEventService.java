package com.github.viniciushfc.hook_dispatcher.service.contract;

import com.github.viniciushfc.hook_dispatcher.domain.entity.WebhookEvent;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookEventResponse;
import com.github.viniciushfc.hook_dispatcher.service.generic.contract.IAbstractService;

import java.util.UUID;

public interface IWebhookEventService extends IAbstractService<WebhookEvent, UUID, WebhookEventResponse> {
}
