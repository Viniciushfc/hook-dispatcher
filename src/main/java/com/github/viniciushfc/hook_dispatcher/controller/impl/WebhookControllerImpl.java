package com.github.viniciushfc.hook_dispatcher.controller.impl;

import com.github.viniciushfc.hook_dispatcher.controller.contract.IWebhookController;
import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.service.impl.WebhookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/webhook")
public class WebhookControllerImpl implements IWebhookController {

    private final WebhookServiceImpl webhookService;

    @GetMapping
    public List<Webhook> findAll() {
        return webhookService.findAll();
    }
}
