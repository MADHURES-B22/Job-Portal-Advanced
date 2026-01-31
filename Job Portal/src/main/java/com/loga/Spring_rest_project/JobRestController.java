package com.loga.Spring_rest_project;

import com.loga.Spring_rest_project.model.JobPost;
import com.loga.Spring_rest_project.model.User;
import com.loga.Spring_rest_project.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//allows you to return data
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("/admin/load")
    public String load(){
        service.load();
        return "success";
    }

    @GetMapping("/user/jobPosts")
    public List<JobPost> getalljobs() {
        return service.getalljobs();
    }

    @GetMapping("/user/jobPosts/keyword/{keyword}")
    public List<JobPost> search(@PathVariable String keyword){
        return service.search(keyword);
    }

    @GetMapping("user/jobPost/{postId}")
    public JobPost getjob(@PathVariable int postId) {
        return service.getjob(postId);
    }

    @GetMapping("/user/jobPost/apply/{postId}")
    public String applyJob(@PathVariable int postId){
        return service.applyJob(postId);
    }


    @PostMapping("/admin/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) //don't forget to put @Request body
    {
        service.addJob(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @PutMapping("/admin/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @DeleteMapping("/admin/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }



}
