package cz.lib.krl.HomeLightControllAPI.Model;

import cz.lib.krl.HomeLightControllAPI.Model.Logging.ILogger;
import cz.lib.krl.HomeLightControllAPI.Repositories.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JobGenerator {

    private final IJobRepository jobRepository;
    private ILogger logger;

    @Autowired
    public JobGenerator(IJobRepository jobRepository, ILogger logger) {
        this.jobRepository = jobRepository;
        this.logger = logger;
    }

    @Scheduled(cron = "0 0 3 * * *")
    public void generateJobs() {
        DaySchedule daySchedule = WeatherApiFacade.generateTodayPlan();

        Job sunrise = new Job();
        sunrise.setAction(ELightStatus.TURNOFF);
        sunrise.setActionTime(daySchedule.getSunrize());
        sunrise.setId(getNextId());
        sunrise.setDone(false);
        jobRepository.save(sunrise);

        Job sunset = new Job();

        sunset.setId(getNextId());
        sunset.setActionTime(daySchedule.getSunset());
        sunset.setAction(ELightStatus.TURNON);
        sunset.setDone(false);
        jobRepository.save(sunset);

        logger.logMessage("Jobs were be generated. (" + jobRepository.getCount() + ")");
        logger.logMessage("Sunrise: " + daySchedule.getSunrize().getTime() + ", Sunset: " + daySchedule.getSunset().getTime());
    }

    private int getNextId() {
        if (jobRepository.getCount() < 1)
            return 0;
        return jobRepository.getAll().get(jobRepository.getCount() - 1).getId() + 1;
    }
}
