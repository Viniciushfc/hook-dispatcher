package com.github.viniciushfc.hook_dispatcher.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class WebhookResponse {

    private UUID id;
    private String name;
    private boolean active;
    private String url;
    private List<WebhookEventResponse> events;
    private LocalDateTime createdAt;
}
