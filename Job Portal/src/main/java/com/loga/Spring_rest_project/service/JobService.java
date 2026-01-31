package com.loga.Spring_rest_project.service;


import com.loga.Spring_rest_project.Repo.JobRepo;
import com.loga.Spring_rest_project.model.JobPost;
import com.loga.Spring_rest_project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void load(){
        List<JobPost> jobs  = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"),"null"),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React"),"null"),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis"),"null"),
                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching"),"null"),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"),"null")
        ));
        repo.saveAll(jobs);
    }
    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }
    public List<JobPost> getalljobs(){
       return repo.findAll();
    }
    public JobPost getjob(int postId) {
       return repo.findById(postId).orElse(new JobPost());
    }
    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }
    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

    public String applyJob(int postId) {
         JobPost job = repo.findById(postId).orElse(null);
         return job.getLink();
    }
}



