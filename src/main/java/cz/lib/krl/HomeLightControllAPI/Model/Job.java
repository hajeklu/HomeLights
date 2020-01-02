package cz.lib.krl.HomeLightControllAPI.Model;

import java.util.Calendar;

public class Job {

    private int id;

    private Calendar actionTime;

    private ELightStatus action;

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getActionTime() {
        return actionTime;
    }

    public void setActionTime(Calendar actionTime) {
        this.actionTime = actionTime;
    }

    public ELightStatus getAction() {
        return action;
    }

    public void setAction(ELightStatus action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Time: " + actionTime.getTime().toString() + ", Action: " + action + ", is done: " + done;
    }

    @Override
    public int hashCode() {
        return id + actionTime.hashCode() + action.hashCode();
    }
}
