package com.bitgo.NotificationManagement.service;

import com.bitgo.NotificationManagement.dtos.NotificationDto;
import com.bitgo.NotificationManagement.dtos.NotificationQuery;
import com.bitgo.NotificationManagement.models.Notification;
import com.bitgo.NotificationManagement.repositories.NotificationRepository;

import java.util.List;


public interface NotificationService {

    Notification createNotification(NotificationDto dto);
    List<Notification> getAllNotifications(NotificationQuery query);
    Notification sendNotification(List<String> emails, Long id);
    Notification updateNotification(long id, NotificationDto dto);
    void deleteNotification(long id);

}
