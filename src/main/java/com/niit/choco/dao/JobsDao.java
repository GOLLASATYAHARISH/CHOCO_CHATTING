package com.niit.choco.dao;

import java.util.List;

import com.niit.choco.model.Blog;
import com.niit.choco.model.Jobs;

public interface JobsDao {
void addJobs(Jobs jobs);
List<Jobs> viewJobs();

void deleteJob(Jobs jobs);
void updateJob(Jobs jobs);

}
