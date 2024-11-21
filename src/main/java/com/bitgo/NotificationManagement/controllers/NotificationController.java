package com.bitgo.NotificationManagement.controllers;

import com.bitgo.NotificationManagement.dtos.NotificationDto;
import com.bitgo.NotificationManagement.dtos.NotificationQuery;
import com.bitgo.NotificationManagement.dtos.SendRequestDto;
import com.bitgo.NotificationManagement.models.Notification;
import com.bitgo.NotificationManagement.service.NotificationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NotificationController {
    private NotificationService service;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello from notification controller", HttpStatus.OK);
    }
    // Validation yet to complete error handling is not yet done
    @PostMapping("/notifications")
    public ResponseEntity<Notification> addNotification(@Valid @RequestBody NotificationDto body) {
        System.out.println(body+"===");
        return new ResponseEntity<Notification>(
                service.createNotification(body), HttpStatus.OK);
    }
    // Also we can have a base response to have proper structure to our response
    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> getAllNotifications(@RequestParam(required = false) NotificationQuery query) {
        return new ResponseEntity<>(
                service.getAllNotifications(query), HttpStatus.OK
        );
    }

    @PutMapping("/notifications/{id}/send")
    public ResponseEntity<Notification> getAllNotifications(@RequestBody SendRequestDto dto, @PathVariable(required = true) Long id) {
        return new ResponseEntity<>(
                service.sendNotification(dto.getEmails(), id), HttpStatus.OK
        );
    }


}
