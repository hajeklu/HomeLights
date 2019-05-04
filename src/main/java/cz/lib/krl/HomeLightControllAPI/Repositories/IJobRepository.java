package cz.lib.krl.HomeLightControllAPI.Repositories;

import cz.lib.krl.HomeLightControllAPI.Model.Job;

import java.util.List;

public interface IJobRepository {

    List<Job> getAll();

    void save(Job job);

    void saveAll(List<Job> jobs);

    void delete(Job job);

    int getCount();


}
