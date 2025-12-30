package com.derek.nasa_social_media_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.model.Reply;
import com.derek.nasa_social_media_app.model.Report;
import com.derek.nasa_social_media_app.model.SubForum;
import com.derek.nasa_social_media_app.model.Thread;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.ReplyRepository;
import com.derek.nasa_social_media_app.repository.ReportRepository;
import com.derek.nasa_social_media_app.repository.SubForumRepository;
import com.derek.nasa_social_media_app.repository.ThreadRepository;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserProfileRepository userRepository;

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private SubForumRepository subForumRepository;

    // Ban/Unban user
    @PutMapping("/users/{id}/ban")
    public UserProfile banUser(@PathVariable Integer id, @RequestBody boolean banned) {
        UserProfile user = userRepository.findById(id).orElseThrow();
        user.setBanned(banned);
        return userRepository.save(user);
    }

    // Delete thread
    @DeleteMapping("/threads/{id}")
    public void deleteThread(@PathVariable Integer id) {
        threadRepository.deleteById(id);
    }

    // Set thread as sticky
    @PutMapping("/threads/{id}/sticky")
    public Thread setSticky(@PathVariable Integer id, @RequestBody boolean sticky) {
        Thread thread = threadRepository.findById(id).orElseThrow();
        thread.setSticky(sticky);
        return threadRepository.save(thread);
    }

    // Set thread as announcement
    @PutMapping("/threads/{id}/announcement")
    public Thread setAnnouncement(@PathVariable Integer id, @RequestBody boolean announcement) {
        Thread thread = threadRepository.findById(id).orElseThrow();
        thread.setAnnouncement(announcement);
        return threadRepository.save(thread);
    }

    // Archive thread
    @PutMapping("/threads/{id}/archive")
    public Thread archiveThread(@PathVariable Integer id, @RequestBody boolean archived) {
        Thread thread = threadRepository.findById(id).orElseThrow();
        thread.setArchived(archived);
        return threadRepository.save(thread);
    }

    // Delete reply
    @DeleteMapping("/replies/{id}")
    public void deleteReply(@PathVariable Integer id) {
        replyRepository.deleteById(id);
    }

    // Manage sub-forums
    @GetMapping("/subforums")
    public List<SubForum> getSubForums() {
        return (List<SubForum>) subForumRepository.findAll();
    }

    @PutMapping("/subforums/{id}")
    public SubForum updateSubForum(@PathVariable Integer id, @RequestBody SubForum subForum) {
        SubForum existing = subForumRepository.findById(id).orElseThrow();
        existing.setName(subForum.getName());
        existing.setDescription(subForum.getDescription());
        return subForumRepository.save(existing);
    }

    @DeleteMapping("/subforums/{id}")
    public void deleteSubForum(@PathVariable Integer id) {
        subForumRepository.deleteById(id);
    }

    // Get all users for moderation
    @GetMapping("/users")
    public List<UserProfile> getUsers() {
        return (List<UserProfile>) userRepository.findAll();
    }

    // Get all reports
    @GetMapping("/reports")
    public List<Report> getReports() {
        return (List<Report>) reportRepository.findAll();
    }

    // Analytics
    @GetMapping("/analytics")
    public String getAnalytics() {
        long userCount = userRepository.count();
        long threadCount = threadRepository.count();
        long replyCount = replyRepository.count();
        return "Users: " + userCount + ", Threads: " + threadCount + ", Replies: " + replyCount;
    }
}