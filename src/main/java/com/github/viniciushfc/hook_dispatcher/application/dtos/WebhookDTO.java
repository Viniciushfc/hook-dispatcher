package com.github.viniciushfc.hook_dispatcher.application.dtos;

import com.github.viniciushfc.hook_dispatcher.application.domain.generic.AbstractEntityDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class WebhookDTO extends AbstractEntityDTO<UUID> {
    private String name;
    private boolean enabled;
    private String url;
    private List<String> events;

}
