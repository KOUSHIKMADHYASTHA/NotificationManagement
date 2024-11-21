package com.bitgo.NotificationManagement.service.implementation;

import com.bitgo.NotificationManagement.dtos.NotificationDto;
import com.bitgo.NotificationManagement.dtos.NotificationQuery;
import com.bitgo.NotificationManagement.models.Notification;
import com.bitgo.NotificationManagement.models.NotificationStatus;
import com.bitgo.NotificationManagement.repositories.NotificationRepository;
import com.bitgo.NotificationManagement.service.NotificationService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(NotificationDto dto) {
        Notification notification = dto.getNotificationFromDto();
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications(NotificationQuery query) {
        // Bug here need to fix
        if(query == null || query.getStatus() == null)
            return notificationRepository.findAll();
        else return notificationRepository.findAllByStatus(query.getStatus());
    }

    @Override
    public Notification sendNotification(List<String> emails, Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        // send notification to emails
        if(notification.isPresent()) {
            Notification notification1 = notification.get();
            notification1.setStatus(NotificationStatus.SENT);
            notificationRepository.save(notification1);
            return notification1;
        }
        throw new IllegalArgumentException("Notification with given id does not exist");
    }

    @Override
    public Notification updateNotification(long id, NotificationDto dto) {
        return null;
    }

    @Override
    public void deleteNotification(long id) {

    }
}
