package efub.insta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("http://ec2-3-36-132-41.ap-northeast-2.compute.amazonaws.com", "http://localhost:3000", "http://localhost:8080")
                .withSockJS();
    }  // 이제 websocket 연결 엔드포인트가 ws://localhost:8080/ws-stomp 가 됨 //allowedOriginPatterns
}