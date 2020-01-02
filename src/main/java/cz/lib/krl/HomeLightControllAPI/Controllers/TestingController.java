package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.JobGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
