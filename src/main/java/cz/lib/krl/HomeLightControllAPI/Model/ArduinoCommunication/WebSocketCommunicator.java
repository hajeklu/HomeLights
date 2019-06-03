/*package cz.lib.krl.HomeLightControllAPI.Model.ArduinoCommunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketCommunicator implements IArduinoCommunicationProvider {

    private SimpMessagingTemplate webSocket;

    @Autowired
    public WebSocketCommunicator(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    @Override
    public void sendMessage(String message) {
        webSocket.convertAndSend("/topic/status", message);
    }
}
*/