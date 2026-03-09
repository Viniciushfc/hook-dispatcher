package com.github.viniciushfc.hook_dispatcher.domain.entity;

import com.github.viniciushfc.hook_dispatcher.domain.entity.generic.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hd_webhook")
public class Webhook extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "webhook")
    private List<WebhookEvent> eventList;
}
