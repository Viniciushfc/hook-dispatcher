package com.github.viniciushfc.hook_dispatcher.application.service;

import com.github.viniciushfc.hook_dispatcher.application.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.application.domain.model.Webhook;
import com.github.viniciushfc.hook_dispatcher.application.repository.IWebhookRepository;
import com.github.viniciushfc.hook_dispatcher.application.service.generic.AbstractBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebhookServiceImpl extends AbstractBaseServiceImpl<UUID, Webhook, WebhookDTO, IWebhookRepository> implements IWebhookService {

    public WebhookServiceImpl(IWebhookRepository repository) {
        super(Webhook.class, WebhookDTO.class, repository);
    }
}
