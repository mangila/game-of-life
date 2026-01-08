package com.github.mangila.gameoflife.web;

import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;

@Component
public class WebSocketEventListener {

    private final SimpUserRegistry userRegistry;

    public WebSocketEventListener(SimpUserRegistry userRegistry) {
        this.userRegistry = userRegistry;
    }
}
