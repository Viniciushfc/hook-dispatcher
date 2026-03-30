package com.github.viniciushfc.hook_dispatcher.domain.entity;

import com.github.viniciushfc.hook_dispatcher.domain.entity.generic.AbstractBaseEntity;
import com.github.viniciushfc.hook_dispatcher.domain.enums.EnumEventName;
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
public class WebhookEvent extends AbstractBaseEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private EnumEventName name;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_webhook")
    private Webhook webhook;

}
