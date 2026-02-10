package com.github.viniciushfc.hook_dispatcher.application.service;

import com.github.viniciushfc.hook_dispatcher.application.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.application.service.generic.IBaseService;

import java.util.UUID;

public interface IWebhookService extends IBaseService<UUID, WebhookDTO> {
}
