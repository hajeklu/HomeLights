package cz.lib.krl.HomeLightControllAPI.Model.Logging;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemoryLogger implements ILogger {

    private List<String> logs = new ArrayList<>();

    @Override
    public void logMessage(String message) {
        logs.add(new Date().toString() + ": " + message);
    }

    @Override
    public List<String> getLogs() {
        return logs;
    }
}
