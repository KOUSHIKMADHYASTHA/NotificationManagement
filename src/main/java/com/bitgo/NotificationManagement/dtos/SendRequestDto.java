package com.bitgo.NotificationManagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SendRequestDto {
    private List<String> emails;
}
