package com.bitgo.NotificationManagement.dtos;

import com.bitgo.NotificationManagement.models.Notification;
import com.bitgo.NotificationManagement.models.NotificationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationDto {
    @NotNull(message = "Current price cannot be null")
    private double currentPrice;
    @NotNull(message = "Daily percent cannot be null")
    private double dailyPercentChange;
    @NotNull(message = "Trading Volume cannot be null")
    private double tradingVolume;
    @NotNull(message = "Status Volume cannot be null")
    private String status;

    public Notification getNotificationFromDto() {
        return Notification.builder()
                .currentPrice(this.currentPrice)
                .dailyPercentChange(this.dailyPercentChange)
                .tradingVolume(this.tradingVolume).status(
                        NotificationStatus.PENDING
                )
                .build();
    }
}
