package cz.lib.krl.HomeLightControllAPI.Model.ArduinoCommunication;

import cz.lib.krl.HomeLightControllAPI.Model.ELightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SimpleHttpCommunicator implements IArduinoCommunicationProvider {

    private LightStatus lightStatus;

    @Autowired
    public SimpleHttpCommunicator(LightStatus lightStatus) {
        this.lightStatus = lightStatus;
    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void turnOn() {
        lightStatus.setStatus(ELightStatus.TURNON);
    }

    @Override
    public void turnOff() {
        lightStatus.setStatus(ELightStatus.TURNOFF);
    }
}
