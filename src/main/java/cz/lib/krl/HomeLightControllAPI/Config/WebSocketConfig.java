/*package cz.lib.krl.HomeLightControllAPI.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // the endpoint for websocket connections
        registry.addEndpoint("/websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");

        // use the /app prefix for others
        registry.setApplicationDestinationPrefixes("/app");
    }

  /*
    private final SimpleWebSocketHandler simpleWebSocketHandler;

    @Autowired
    public WebSocketConfig(SimpleWebSocketHandler simpleWebSocketHandler) {
        this.simpleWebSocketHandler = simpleWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleWebSocketHandler, "/websocket");
    }
}
*/