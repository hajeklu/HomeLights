package cz.lib.krl.HomeLightControllAPI.Model;


import java.util.Calendar;

public class DaySchedule  {

    private Calendar sunrize;

    private Calendar sunset;


    public Calendar getSunset() {
        return sunset;
    }

    public void setSunset(Calendar sunset) {
        this.sunset = sunset;
    }

    public Calendar getSunrize() {
        return sunrize;
    }

    public void setSunrize(Calendar sunrize) {
        this.sunrize = sunrize;
    }

}
