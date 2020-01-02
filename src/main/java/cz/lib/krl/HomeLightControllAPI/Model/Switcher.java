package cz.lib.krl.HomeLightControllAPI.Model;

import cz.lib.krl.HomeLightControllAPI.Model.ArduinoCommunication.IArduinoCommunicationProvider;
import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import cz.lib.krl.HomeLightControllAPI.Repositories.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Switcher {

    private IJobRepository jobRepository;
    private IArduinoCommunicationProvider iArduinoCommunicationProvider;
    private ILogger logger;
    private LightStatus lightStatus;

    @Autowired
    public Switcher(IJobRepository iJobRepository, IArduinoCommunicationProvider iArduinoCommunicationProvider, ILogger logger, LightStatus lightStatus) {
        this.jobRepository = iJobRepository;
        this.iArduinoCommunicationProvider = iArduinoCommunicationProvider;
        this.logger = logger;
        this.lightStatus = lightStatus;
    }

    @Scheduled(fixedRate = 10000)
    public void decide() {
        Calendar calendar = Calendar.getInstance();

        for (Job job : jobRepository.getAll()) {
            if (!job.isDone() && calendar.compareTo(job.getActionTime()) > 0) {
                lightStatus.setStatus(job.getAction());
                iArduinoCommunicationProvider.sendMessage(lightStatus.getStatus().toString());
                job.setDone(true);
                logger.logMessage("Status change by switcher on: " + lightStatus.getStatus().toString());
            }
        }
    }

}
