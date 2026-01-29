package com.github.viniciushfc.hook_dispatcher.application.domain.model;

import com.github.viniciushfc.hook_dispatcher.application.domain.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidade que representa um webhook no sistema.
 * <p>
 * Um webhook é um endpoint HTTP que recebe notificações de eventos
 * específicos. Esta entidade armazena a configuração do webhook,
 * incluindo URL de destino, status de ativação e lista de eventos
 * aos quais está inscrito.
 * </p>
 *
 * @author ViniciusHFC
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hd_webhook")
public class Webhook extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "url")
    private String url;

    @ElementCollection
    @CollectionTable(
            name = "hd_webhook_events",
            joinColumns = {@JoinColumn(name = "id_webhook")}
    )
    private List<String> events;

}
