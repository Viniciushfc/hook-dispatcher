package com.github.viniciushfc.hook_dispatcher.application.controller;

import com.github.viniciushfc.hook_dispatcher.application.controller.generic.IBaseController;
import com.github.viniciushfc.hook_dispatcher.application.dtos.WebhookDTO;

import java.util.UUID;

public interface IWebhookController extends IBaseController<UUID, WebhookDTO> {

    String PATH = "/webhook";

}
