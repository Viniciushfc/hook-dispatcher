package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl extends AbstractBaseServiceImpl<Webhook, UUID, WebhookDTO> implements IWebhookService {

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public WebhookDTO save(WebhookDTO dto) {
        log.info("Saving new webhook");
        Webhook webhook = modelMapper.map(dto, Webhook.class);
        WebhookDTO saved = modelMapper.map(repository.save(webhook), WebhookDTO.class);
            log.info("Webhook saved successfully. id={}", saved.getId());
        return saved;
    }

    @Override
    public WebhookDTO update(UUID idWebhook, WebhookDTO dto) {
        log.info("Updating webhook. id={}", idWebhook);
        return null;
    }

    @Override
    public void deactivateWebhook(UUID idWebhook) {
        log.info("Deactivating webhook. id={}", idWebhook);
        Webhook webhook = findById(idWebhook);
        webhook.setActive(false);
        repository.save(webhook);
        log.info("Webhook deactivated successfully. id={}", idWebhook);
    }
}
