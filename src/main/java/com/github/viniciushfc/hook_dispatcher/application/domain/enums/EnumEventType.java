package com.github.viniciushfc.hook_dispatcher.application.domain.enums;

import com.github.viniciushfc.hook_dispatcher.application.domain.generic.IEnum;

public enum EnumEventType implements IEnum<String, String> {

    // ===== USUÁRIOS =====
    USER_CREATED("user.created", "Usuário criado"),
    USER_UPDATED("user.updated", "Usuário atualizado"),
    USER_DELETED("user.deleted", "Usuário deletado"),
    USER_ACTIVATED("user.activated", "Usuário ativado"),
    USER_DEACTIVATED("user.deactivated", "Usuário desativado"),
    USER_PASSWORD_CHANGED("user.password_changed", "Senha alterada"),
    USER_EMAIL_VERIFIED("user.email_verified", "Email verificado"),
    USER_LOGIN("user.login", "Usuário fez login"),
    USER_LOGOUT("user.logout", "Usuário fez logout"),

    // ===== PEDIDOS/ORDERS =====
    ORDER_CREATED("order.created", "Pedido criado"),
    ORDER_UPDATED("order.updated", "Pedido atualizado"),
    ORDER_CANCELLED("order.cancelled", "Pedido cancelado"),
    ORDER_COMPLETED("order.completed", "Pedido concluído"),
    ORDER_SHIPPED("order.shipped", "Pedido enviado"),
    ORDER_DELIVERED("order.delivered", "Pedido entregue"),
    ORDER_REFUNDED("order.refunded", "Pedido reembolsado"),

    // ===== PAGAMENTOS =====
    PAYMENT_RECEIVED("payment.received", "Pagamento recebido"),
    PAYMENT_FAILED("payment.failed", "Pagamento falhou"),
    PAYMENT_PENDING("payment.pending", "Pagamento pendente"),
    PAYMENT_REFUNDED("payment.refunded", "Pagamento reembolsado"),
    PAYMENT_DISPUTED("payment.disputed", "Pagamento em disputa"),

    // ===== PRODUTOS =====
    PRODUCT_CREATED("product.created", "Produto criado"),
    PRODUCT_UPDATED("product.updated", "Produto atualizado"),
    PRODUCT_DELETED("product.deleted", "Produto deletado"),
    PRODUCT_OUT_OF_STOCK("product.out_of_stock", "Produto esgotado"),
    PRODUCT_BACK_IN_STOCK("product.back_in_stock", "Produto disponível"),

    // ===== NOTIFICAÇÕES =====
    NOTIFICATION_SENT("notification.sent", "Notificação enviada"),
    NOTIFICATION_FAILED("notification.failed", "Notificação falhou"),
    EMAIL_SENT("email.sent", "Email enviado"),
    EMAIL_BOUNCED("email.bounced", "Email retornou"),
    SMS_SENT("sms.sent", "SMS enviado"),
    SMS_FAILED("sms.failed", "SMS falhou"),

    // ===== DOCUMENTOS/ARQUIVOS =====
    DOCUMENT_UPLOADED("document.uploaded", "Documento enviado"),
    DOCUMENT_PROCESSED("document.processed", "Documento processado"),
    DOCUMENT_APPROVED("document.approved", "Documento aprovado"),
    DOCUMENT_REJECTED("document.rejected", "Documento rejeitado"),

    // ===== CUSTOM/OUTROS =====
    CUSTOM_EVENT("custom.event", "Evento customizado");;

    private String key;
    private String value;

    EnumEventType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
