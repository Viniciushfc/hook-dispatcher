package com.github.viniciushfc.hook_dispatcher.service.impl;

import com.github.viniciushfc.hook_dispatcher.domain.entity.WebhookEvent;
import com.github.viniciushfc.hook_dispatcher.dtos.response.WebhookEventResponse;
import com.github.viniciushfc.hook_dispatcher.service.contract.IWebhookEventService;
import com.github.viniciushfc.hook_dispatcher.service.generic.AbstractBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WebhookEventServiceImpl extends AbstractBaseServiceImpl<WebhookEvent, UUID, WebhookEventResponse> implements IWebhookEventService {
}
