package cz.lib.krl.HomeLightControllAPI.Model.WebSocket;

import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketMessaging implements IWebSocket {

    private SimpMessagingTemplate webSocket;

    @Autowired
    public WebSocketMessaging(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    @Override
    public void sendMessage(String destination, String message) {
        webSocket.convertAndSend(destination, message);
    }
}
