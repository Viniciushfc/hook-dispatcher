package com.github.viniciushfc.hook_dispatcher.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class WebhookDTO {

    private UUID id;
    private String name;
    private boolean active;
    private String url;
    private List<WebhookEventDTO> events;
}
