package com.bitgo.NotificationManagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Getter
@Setter
@EnableJpaAuditing
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double currentPrice;
    private double dailyPercentChange;
    private double tradingVolume;

    // If user exists this will be in separate table may be user notification mapping table
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
