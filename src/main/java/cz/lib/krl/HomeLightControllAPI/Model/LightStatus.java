package cz.lib.krl.HomeLightControllAPI.Model;

public class LightStatus {

    private static ELightStatus status = ELightStatus.TURNOFF;

    public static ELightStatus getStatus() {
        return status;
    }

    public static void setStatus(ELightStatus status) {
        LightStatus.status = status;
    }
}
