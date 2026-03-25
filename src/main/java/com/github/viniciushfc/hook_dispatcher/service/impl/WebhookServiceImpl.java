package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.repository.WebhookRepository;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl extends AbstractBaseServiceImpl<Webhook, UUID, WebhookDTO> implements IWebhookService {

    private static final Logger log = LoggerFactory.getLogger(WebhookServiceImpl.class);

    private final ModelMapper modelMapper;
    private final WebhookRepository webhookRepository;

    @Override
    public WebhookDTO save(WebhookDTO dto) {
        log.info("Salvando novo webhook");
        Webhook webhook = modelMapper.map(dto, Webhook.class);
        WebhookDTO saved = modelMapper.map(webhookRepository.save(webhook), WebhookDTO.class);
        log.info("Webhook salvo com sucesso. id={}", saved.getId());
        return saved;
    }

    @Override
    public WebhookDTO update(UUID idWebhook, WebhookDTO dto) {
        log.info("Atualizando webhook. id={}", idWebhook);
        return null;
    }

    @Override
    public void desativeWebhook(UUID idWebhook) {
        log.info("Desativando webhook. id={}", idWebhook);
    }
}
