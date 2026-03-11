package com.github.viniciushfc.hook_dispatcher.controller.contract;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;

import java.util.List;

public interface IWebhookController {

    List<Webhook> findAll();
}
