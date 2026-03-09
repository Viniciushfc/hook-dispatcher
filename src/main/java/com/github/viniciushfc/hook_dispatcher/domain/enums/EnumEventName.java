package com.github.viniciushfc.hook_dispatcher.domain.enums;

import com.github.viniciushfc.hook_dispatcher.domain.enums.generic.IEnum;

public enum EnumEventName implements IEnum<String, String> {

    // ─── CRUD ───
    RESOURCE_CREATED("resource.created", "Recurso criado"),
    RESOURCE_UPDATED("resource.updated", "Recurso atualizado"),
    RESOURCE_DELETED("resource.deleted", "Recurso deletado"),
    RESOURCE_RETRIEVED("resource.retrieved", "Recurso consultado"),

    // ─── Pagamentos ───
    PAYMENT_INITIATED("payment.initiated", "Pagamento iniciado"),
    PAYMENT_COMPLETED("payment.completed", "Pagamento concluído"),
    PAYMENT_FAILED("payment.failed", "Pagamento falhou"),
    PAYMENT_REFUNDED("payment.refunded", "Pagamento estornado"),
    PAYMENT_CANCELLED("payment.cancelled", "Pagamento cancelado"),
    PAYMENT_EXPIRED("payment.expired", "Pagamento expirado"),
    PAYMENT_DISPUTED("payment.disputed", "Pagamento em disputa"),

    // ─── Assinatura / Subscription ───
    SUBSCRIPTION_CREATED("subscription.created", "Assinatura criada"),
    SUBSCRIPTION_ACTIVATED("subscription.activated", "Assinatura ativada"),
    SUBSCRIPTION_RENEWED("subscription.renewed", "Assinatura renovada"),
    SUBSCRIPTION_PAUSED("subscription.paused", "Assinatura pausada"),
    SUBSCRIPTION_CANCELLED("subscription.cancelled", "Assinatura cancelada"),
    SUBSCRIPTION_EXPIRED("subscription.expired", "Assinatura expirou"),

    // ─── Pedidos / Order ───
    ORDER_CREATED("order.created", "Pedido criado"),
    ORDER_CONFIRMED("order.confirmed", "Pedido confirmado"),
    ORDER_SHIPPED("order.shipped", "Pedido enviado"),
    ORDER_DELIVERED("order.delivered", "Pedido entregue"),
    ORDER_CANCELLED("order.cancelled", "Pedido cancelado"),
    ORDER_RETURNED("order.returned", "Pedido devolvido"),

    // ─── Usuário ───
    USER_REGISTERED("user.registered", "Usuário registrado"),
    USER_VERIFIED("user.verified", "Usuário verificado"),
    USER_UPDATED("user.updated", "Usuário atualizado"),
    USER_DELETED("user.deleted", "Usuário deletado"),
    USER_SUSPENDED("user.suspended", "Usuário suspenso"),

    // ─── Notificação / Sistema ───
    NOTIFICATION_SENT("notification.sent", "Notificação enviada"),
    NOTIFICATION_FAILED("notification.failed", "Notificação falhou"),
    WEBHOOK_PING("webhook.ping", "Teste de conectividade"),
    WEBHOOK_DISABLED("webhook.disabled", "Webhook desativado por falhas"),

    // ─── Custom ───
    CUSTOM("custom.event", "Evento customizado pelo usuário"),
    ;

    private final String key;
    private final String value;

    EnumEventName(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
