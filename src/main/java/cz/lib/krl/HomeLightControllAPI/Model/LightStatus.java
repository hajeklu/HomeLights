package cz.lib.krl.HomeLightControllAPI.Model;
import org.springframework.stereotype.Service;

@Service
public class LightStatus {

    private ELightStatus status = ELightStatus.TURNOFF;

    public ELightStatus getStatus() {
        return status;
    }

    public void setStatus(ELightStatus status) {
        this.status = status;
    }
}
