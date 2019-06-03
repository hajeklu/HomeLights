package cz.lib.krl.HomeLightControllAPI.Model.ArduinoCommunication;


public interface IArduinoCommunicationProvider {

    void sendMessage(String message);

    void turnOn();

    void turnOff();
}
