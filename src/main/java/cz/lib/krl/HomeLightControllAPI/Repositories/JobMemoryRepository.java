package cz.lib.krl.HomeLightControllAPI.Repositories;

import cz.lib.krl.HomeLightControllAPI.Model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobMemoryRepository implements IJobRepository {

    List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> getAll() {
        return jobs;
    }

    @Override
    public void save(Job job) {
        jobs.add(job);
    }

    @Override
    public void saveAll(List<Job> jobs) {
        jobs.addAll(jobs);
    }

    @Override
    public void delete(Job job) {
        for(int i = 0; i < jobs.size(); i++){
            if(job.getId()==jobs.get(i).getId())
                jobs.remove(i);
        }
    }

    @Override
    public int getCount() {
        return jobs.size();
    }


}
