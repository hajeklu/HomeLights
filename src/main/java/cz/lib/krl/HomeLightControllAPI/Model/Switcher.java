package cz.lib.krl.HomeLightControllAPI.Model;

import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import cz.lib.krl.HomeLightControllAPI.Model.WebSocket.IWebSocket;
import cz.lib.krl.HomeLightControllAPI.Repositories.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class Switcher {

    private IJobRepository jobRepository;
    private IWebSocket iWebSocket;
    private ILogger logger;

    @Autowired
    public Switcher(IJobRepository iJobRepository, IWebSocket iWebSocket, ILogger logger) {
        this.jobRepository = iJobRepository;
        this.iWebSocket = iWebSocket;
        this.logger = logger;
    }

    @Scheduled(fixedRate = 2000)
    public void decide() {
        Calendar calendar = Calendar.getInstance();

        for (Job job : jobRepository.getAll()) {
            if (!job.isDone() && calendar.compareTo(job.getActionTime()) > 0) {
                LightStatus.setStatus(job.getAction());
                iWebSocket.sendMessage("/topic/status", LightStatus.getStatus().toString());
                job.setDone(true);
                logger.logMessage(new Date().toString() + ": Status change on: " + LightStatus.getStatus().toString());
            }
        }
    }

}
