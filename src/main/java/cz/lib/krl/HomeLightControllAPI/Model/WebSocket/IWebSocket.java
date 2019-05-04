package cz.lib.krl.HomeLightControllAPI.Model.WebSocket;

public interface IWebSocket {

    void sendMessage(String destination, String message);
}
