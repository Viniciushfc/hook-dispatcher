package com.github.viniciushfc.hook_dispatcher.dtos;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import com.github.viniciushfc.hook_dispatcher.domain.enums.EnumEventName;
import lombok.Data;

import java.util.UUID;

@Data
public class WebhookEventDTO {

    private UUID id;
    private EnumEventName name;
    private boolean ativo;
    private Webhook webhook;
}
