package cz.lib.krl.HomeLightControllAPI.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cz.lib.krl.HomeLightControllAPI.Config.AppConfig;
import cz.lib.krl.HomeLightControllAPI.Util.HttpGetUtil;
import cz.lib.krl.HomeLightControllAPI.Util.StringUtil;

import java.io.IOException;
import java.util.Calendar;

public class WeatherApiFacade {


    public static DaySchedule generateTodayPlan() {

        //http://api.openweathermap.org/data/2.5/weather?q=PRAGUE,cz&APPID=e29e56a6e5381d1b9127c591660a9856

        String json = HttpGetUtil.GetDataFromUrl(AppConfig.WeatherApi);
        if (StringUtil.isEmptyOrNull(json)) {
            return null;
        }

        try {
            final ObjectNode node = new ObjectMapper().readValue(json, ObjectNode.class);
            String sunrise = node.path("sys").path("sunrise").asText();
            String sunset = node.path("sys").path("sunset").asText();
            Calendar sunriseCal = Calendar.getInstance();
            sunriseCal.setTimeInMillis(Integer.parseInt(sunrise) * 1000L);
            Calendar sunsetCal = Calendar.getInstance();
            sunsetCal.setTimeInMillis(Integer.parseInt(sunset) * 1000L);
            DaySchedule daySchedule = new DaySchedule();
            daySchedule.setSunrize(sunriseCal);
            daySchedule.setSunset(sunsetCal);
            return daySchedule;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
