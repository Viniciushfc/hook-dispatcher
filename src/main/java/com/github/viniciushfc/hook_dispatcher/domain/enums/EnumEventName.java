package com.github.viniciushfc.hook_dispatcher.domain.enums;

import com.github.viniciushfc.hook_dispatcher.domain.enums.contract.IEnum;

public enum EnumEventName implements IEnum<String, String> {

    // ─── CRUD ───
    RESOURCE_CREATED("resource.created", "Resource created"),
    RESOURCE_UPDATED("resource.updated", "Resource updated"),
    RESOURCE_DELETED("resource.deleted", "Resource deleted"),
    RESOURCE_RETRIEVED("resource.retrieved", "Resource retrieved"),

    // ─── Payments ───
    PAYMENT_INITIATED("payment.initiated", "Payment initiated"),
    PAYMENT_COMPLETED("payment.completed", "Payment completed"),
    PAYMENT_FAILED("payment.failed", "Payment failed"),
    PAYMENT_REFUNDED("payment.refunded", "Payment refunded"),
    PAYMENT_CANCELLED("payment.cancelled", "Payment cancelled"),
    PAYMENT_EXPIRED("payment.expired", "Payment expired"),
    PAYMENT_DISPUTED("payment.disputed", "Payment disputed"),

    // ─── Subscription ───
    SUBSCRIPTION_CREATED("subscription.created", "Subscription created"),
    SUBSCRIPTION_ACTIVATED("subscription.activated", "Subscription activated"),
    SUBSCRIPTION_RENEWED("subscription.renewed", "Subscription renewed"),
    SUBSCRIPTION_PAUSED("subscription.paused", "Subscription paused"),
    SUBSCRIPTION_CANCELLED("subscription.cancelled", "Subscription cancelled"),
    SUBSCRIPTION_EXPIRED("subscription.expired", "Subscription expired"),

    // ─── Orders ───
    ORDER_CREATED("order.created", "Order created"),
    ORDER_CONFIRMED("order.confirmed", "Order confirmed"),
    ORDER_SHIPPED("order.shipped", "Order shipped"),
    ORDER_DELIVERED("order.delivered", "Order delivered"),
    ORDER_CANCELLED("order.cancelled", "Order cancelled"),
    ORDER_RETURNED("order.returned", "Order returned"),

    // ─── Users ───
    USER_REGISTERED("user.registered", "User registered"),
    USER_VERIFIED("user.verified", "User verified"),
    USER_UPDATED("user.updated", "User updated"),
    USER_DELETED("user.deleted", "User deleted"),
    USER_SUSPENDED("user.suspended", "User suspended"),

    // ─── Notifications / System ───
    NOTIFICATION_SENT("notification.sent", "Notification sent"),
    NOTIFICATION_FAILED("notification.failed", "Notification failed"),
    WEBHOOK_PING("webhook.ping", "Connectivity test"),
    WEBHOOK_DISABLED("webhook.disabled", "Webhook disabled due to failures"),

    // ─── Custom ───
    CUSTOM("custom.event", "Custom event"),
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
