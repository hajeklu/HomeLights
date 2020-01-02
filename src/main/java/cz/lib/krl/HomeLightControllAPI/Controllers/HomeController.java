package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.ArduinoCommunication.IArduinoCommunicationProvider;
import cz.lib.krl.HomeLightControllAPI.Model.ELightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private ILogger iLogger;
    private LightStatus lightStatus;

    @Autowired
    public HomeController(IArduinoCommunicationProvider arduinoCom, ILogger iLogger, LightStatus lightStatus) {
        this.iLogger = iLogger;
        this.lightStatus = lightStatus;
    }

    @RequestMapping("/light")
    @ResponseBody
    public ELightStatus getLightStatus() {

        return lightStatus.getStatus();
    }

    @RequestMapping("/light/on")
    public void turnOnTheLight() {
        lightStatus.setStatus(ELightStatus.TURNON);
        iLogger.logMessage("TURNON");
    }

    @RequestMapping("/light/off")
    public void turnOffTheLight() {
        lightStatus.setStatus(ELightStatus.TURNOFF);
        iLogger.logMessage("TURNOFF");
    }

    @RequestMapping("/")
    public String index(){
        return "/index.html";
    }

}
