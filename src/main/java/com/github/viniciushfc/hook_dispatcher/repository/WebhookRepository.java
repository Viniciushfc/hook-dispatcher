package com.github.viniciushfc.hook_dispatcher.repository;

import com.github.viniciushfc.hook_dispatcher.domain.entity.Webhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WebhookRepository extends JpaRepository<Webhook, UUID> {
}
