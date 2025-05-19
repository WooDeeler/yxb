package com.kongke.domain.chat.service;

import com.kongke.domain.chat.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepo chatRepo;

}
