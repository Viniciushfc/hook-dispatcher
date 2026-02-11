package com.github.viniciushfc.hook_dispatcher.application.controller.impl;

import com.github.viniciushfc.hook_dispatcher.application.controller.IWebhookController;
import com.github.viniciushfc.hook_dispatcher.application.controller.generic.AbstractControllerImpl;
import com.github.viniciushfc.hook_dispatcher.application.dtos.WebhookDTO;
import com.github.viniciushfc.hook_dispatcher.application.service.IWebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(IWebhookController.PATH)
@RequiredArgsConstructor
public class WebhookControllerImpl extends AbstractControllerImpl<UUID, WebhookDTO, IWebhookService> implements IWebhookController {

    private final IWebhookService webhookService;
}
