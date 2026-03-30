package com.github.viniciushfc.hook_dispatcher.dtos.request;

import com.github.viniciushfc.hook_dispatcher.domain.enums.EnumEventName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WebhookEventRequest {

    @NotNull(message = "Event name is required")
    private EnumEventName name;
}
