package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl extends AbstractBaseServiceImpl<Webhook, UUID, WebhookDTO> implements IWebhookService {
}
