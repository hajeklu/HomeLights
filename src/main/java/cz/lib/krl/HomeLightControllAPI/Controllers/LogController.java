package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {

    private ILogger logger;

    @Autowired
    public LogController(ILogger logger) {
        this.logger = logger;
    }

    @ResponseBody
    @RequestMapping("/log")
    public String getLogs(){
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : logger.getLogs()) {
            stringBuilder.append(s);
            stringBuilder.append("<br>");
        }
        return stringBuilder.toString();
    }
}
