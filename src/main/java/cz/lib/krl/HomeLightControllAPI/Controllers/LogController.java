package cz.lib.krl.HomeLightControllAPI.Controllers;

import cz.lib.krl.HomeLightControllAPI.Model.Job;
import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import cz.lib.krl.HomeLightControllAPI.Repositories.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {

    private ILogger logger;
    private IJobRepository jobRepository;

    @Autowired
    public LogController(ILogger logger, IJobRepository jobRepository) {
        this.logger = logger;
        this.jobRepository = jobRepository;
    }

    @ResponseBody
    @RequestMapping("/log")
    public String getLogs() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : logger.getLogs()) {
            stringBuilder.append(s);
            stringBuilder.append("<br>");
        }
        return stringBuilder.toString();
    }

    @ResponseBody
    @RequestMapping("/jobs")
    public String getJobList() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Job job : jobRepository.getAll()) {
            stringBuilder.append(job);
            stringBuilder.append("<br>");
        }

        return stringBuilder.toString();
    }
}
