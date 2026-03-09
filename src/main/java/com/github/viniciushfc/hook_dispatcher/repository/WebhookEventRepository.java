package com.github.viniciushfc.hook_dispatcher.repository;

import com.github.viniciushfc.hook_dispatcher.domain.entity.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WebhookEventRepository extends JpaRepository<WebhookEvent, UUID> {
}
