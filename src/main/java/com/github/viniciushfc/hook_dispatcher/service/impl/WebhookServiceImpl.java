package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class WebhookServiceImpl extends AbstractBaseServiceImpl<Webhook, UUID, WebhookResponse> implements IWebhookService {

    @Override
    @Transactional
    public WebhookResponse save(WebhookRequest request) {
        log.info("Saving new webhook");

        Webhook webhook = modelMapper.map(request, Webhook.class);
        Webhook persisted = repository.save(webhook);

        log.info("Webhook saved successfully. id={}", persisted.getId());
        return modelMapper.map(persisted, WebhookResponse.class);
    }

    @Override
    @Transactional
    public WebhookResponse update(UUID idWebhook, WebhookRequest request) {
        log.info("Updating webhook. id={}", idWebhook);

        Webhook webhook = findEntityById(idWebhook);
        modelMapper.map(request, webhook);

        Webhook updated = repository.save(webhook);
        log.info("Webhook updated successfully. id={}", updated.getId());

        return modelMapper.map(updated, WebhookResponse.class);
    }

    @Override
    @Transactional
    public void deactivateWebhook(UUID idWebhook) {
        log.info("Deactivating webhook. id={}", idWebhook);

        Webhook webhook = findEntityById(idWebhook);
        webhook.setActive(false);

        repository.save(webhook);
        log.info("Webhook deactivated successfully. id={}", idWebhook);
    }
}
