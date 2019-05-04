package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.ELightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.JobGenerator;
import cz.lib.krl.HomeLightControllAPI.Model.LightStatus;
import cz.lib.krl.HomeLightControllAPI.Model.WeatherApiFacade;
import cz.lib.krl.HomeLightControllAPI.Repositories.JobMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @Autowired
    private JobGenerator jobGenerator;

    @GetMapping("/generate")
    @ResponseBody
    public String generate() {
        jobGenerator.generateJobs();
        return "Hotovo";
    }
}
