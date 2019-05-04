package cz.lib.krl.HomeLightControllAPI.Model.Logging;

import java.util.List;

public interface ILogger {

    void logMessage(String message);

    List<String> getLogs();

}
