package com.github.viniciushfc.hook_dispatcher.application.domain.model;

import com.github.viniciushfc.hook_dispatcher.application.domain.enums.EnumEventType;
import com.github.viniciushfc.hook_dispatcher.application.domain.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hd_webhook_event")
public class WebhookEvent extends AbstractEntity {

    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EnumEventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_webhook", nullable = false)
    private Webhook webhook;
}
