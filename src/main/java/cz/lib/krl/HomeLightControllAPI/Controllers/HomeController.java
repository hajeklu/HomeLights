package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.ELightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import cz.lib.krl.HomeLightControllAPI.Model.WebSocket.IWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {


    private IWebSocket iwebSocket;
    private ILogger iLogger;

    @Autowired
    public HomeController(IWebSocket iwebSocket, ILogger iLogger) {
        this.iwebSocket = iwebSocket;
        this.iLogger = iLogger;
    }

    @GetMapping("/light")
    @ResponseBody
    public ELightStatus getLightStatus() {
        iLogger.logMessage(new Date().toString() + ": Status get");
        return LightStatus.getStatus();
    }

    @RequestMapping("/light/on")
    public String turnOnTheLight() {
        iLogger.logMessage(new Date().toString() + ": ON");
        LightStatus.setStatus(ELightStatus.TURNON);
        iwebSocket.sendMessage("/topic/status", LightStatus.getStatus().toString());
        return "/index.html";
    }

    @RequestMapping("/light/off")
    public String turnOffTheLight() {
        iLogger.logMessage(new Date().toString() + ": OFF");
        LightStatus.setStatus(ELightStatus.TURNOFF);
        iwebSocket.sendMessage("/topic/status", LightStatus.getStatus().toString());
        return "/index.html";
    }

}
