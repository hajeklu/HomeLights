package cz.lib.krl.HomeLightControllAPI.Config;

/*import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SimpleWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        System.out.println("error occured at sender " + session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(String.format("Session %s closed because of %s", session.getId(), status.getReason()));

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connected ... " + session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        System.out.println("Message received: " + jsonTextMessage.getPayload());

        WebSocketMessage<String> message = new WebSocketMessage<String>() {
            @Override
            public String getPayload() {
                return LightStatus.getStatus().toString();
            }

            @Override
            public int getPayloadLength() {
                return LightStatus.getStatus().toString().length();
            }

            @Override
            public boolean isLast() {
                return false;
            }
        };
        session.sendMessage(message);

    }


}*/