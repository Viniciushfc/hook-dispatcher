package com.github.viniciushfc.hook_dispatcher.application.repository;

import com.github.viniciushfc.hook_dispatcher.application.domain.model.Webhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repositório responsável pela persistência e recuperação de entidades {@link Webhook}.
 *
 * @author Vinicius Henry Ferrari Campos
 */
@Repository
public interface IWebhookRepository extends JpaRepository<Webhook, UUID> {
}
