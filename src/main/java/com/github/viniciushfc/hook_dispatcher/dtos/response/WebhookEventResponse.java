package com.github.viniciushfc.hook_dispatcher.dtos.response;

import com.github.viniciushfc.hook_dispatcher.domain.enums.EnumEventName;
import lombok.Data;

import java.util.UUID;

@Data
public class WebhookEventResponse {

    private UUID id;
    private EnumEventName name;
    private boolean active;
}
