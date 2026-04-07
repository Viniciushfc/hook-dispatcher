package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.domain.entity.WebhookEvent;
import com.github.viniciushfc.hook_dispatcher.domain.enums.EnumEventName;
import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookEventRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.request.WebhookRequest;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookResponse;
import com.github.viniciushfc.hook_dispatcher.exception.HookDispatcherException;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookEventService;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl extends AbstractBaseServiceImpl<Webhook, UUID, WebhookResponse> implements IWebhookService {

    private final IWebhookEventService webhookEventService;

    @Override
    @Transactional
    public WebhookResponse save(WebhookRequest request) {
        log.info("Saving new webhook");

        List<WebhookEventRequest> events = request.getEvents();
        if (request.getEvents() != null && !request.getEvents().isEmpty()) {
            for (WebhookEventRequest webhookEventRequest : request.getEvents()) {
                boolean equal = Arrays.stream(EnumEventName.values())
                        .anyMatch(e -> e.name().equals(webhookEventRequest.getName().getKey()));

                if (equal) {
                    events.add(webhookEventRequest);
                } else {
                    throw new HookDispatcherException("Webhook event name: " + webhookEventRequest.getName().getKey() + " not found");
                }
            }
        }

        Webhook webhook = modelMapper.map(request, Webhook.class);
        webhook.setActive(true);
        if (events != null && !events.isEmpty()) {
            webhook.setEventList(events.stream().map(event -> modelMapper.map(event, WebhookEvent.class)).toList());
        }
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
