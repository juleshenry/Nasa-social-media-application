package com.derek.nasa_social_media_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.derek.nasa_social_media_app.model.Reply;
import com.derek.nasa_social_media_app.model.Report;
import com.derek.nasa_social_media_app.model.SubForum;
import com.derek.nasa_social_media_app.model.Thread;
import com.derek.nasa_social_media_app.model.Message;
import com.derek.nasa_social_media_app.model.Notification;
import com.derek.nasa_social_media_app.model.Reply;
import com.derek.nasa_social_media_app.model.Report;
import com.derek.nasa_social_media_app.model.SubForum;
import com.derek.nasa_social_media_app.model.Thread;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.model.Vote;
import com.derek.nasa_social_media_app.repository.MessageRepository;
import com.derek.nasa_social_media_app.repository.NotificationRepository;
import com.derek.nasa_social_media_app.repository.ReplyRepository;
import com.derek.nasa_social_media_app.repository.ReportRepository;
import com.derek.nasa_social_media_app.repository.SubForumRepository;
import com.derek.nasa_social_media_app.repository.ThreadRepository;
import com.derek.nasa_social_media_app.component.NasaApiService;
import com.derek.nasa_social_media_app.model.KnowledgeBase;
import com.derek.nasa_social_media_app.repository.KnowledgeBaseRepository;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;
import com.derek.nasa_social_media_app.repository.VoteRepository;

@RestController
public class SubForumController {

    @Autowired
    private SubForumRepository subForumRepository;

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private NasaApiService nasaApiService;

    @Autowired
    private KnowledgeBaseRepository knowledgeBaseRepository;

    @GetMapping("/subforums")
    public List<SubForum> getAllSubForums() {
        return (List<SubForum>) subForumRepository.findAll();
    }

    @GetMapping("/users/{id}/profile")
    public UserProfile getUserProfile(@PathVariable Integer id) {
        return userProfileRepository.findById(id).orElseThrow();
    }

    @GetMapping("/search/threads")
    public List<Thread> searchThreads(@RequestParam String query) {
        List<Thread> results = threadRepository.findByTitleContainingIgnoreCase(query);
        results.addAll(threadRepository.findByContentContainingIgnoreCase(query));
        return results.stream().distinct().toList();
    }

    @GetMapping("/search/users")
    public List<UserProfile> searchUsers(@RequestParam String query) {
        return userProfileRepository.findByUsernameContainingIgnoreCase(query);
    }

    @GetMapping("/notifications")
    public List<Notification> getNotifications(@RequestParam Integer userId) {
        UserProfile user = userProfileRepository.findById(userId).orElseThrow();
        return notificationRepository.findByRecipientAndIsRead(user, false);
    }

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @GetMapping("/messages")
    public List<Message> getMessages(@RequestParam Integer userId) {
        UserProfile user = userProfileRepository.findById(userId).orElseThrow();
        return messageRepository.findByRecipient(user);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart MultipartFile file) {
        // Simple implementation, save to /uploads
        // In real app, use service to handle storage
        return "File uploaded: " + file.getOriginalFilename();
    }

    @GetMapping("/nasa/apod")
    public String getNasaApod() {
        return nasaApiService.getApod();
    }

    @GetMapping("/knowledgebase")
    public List<KnowledgeBase> getKnowledgeBase() {
        return (List<KnowledgeBase>) knowledgeBaseRepository.findAll();
    }

    @PostMapping("/knowledgebase")
    public KnowledgeBase createKnowledgeBase(@RequestBody KnowledgeBase kb) {
        return knowledgeBaseRepository.save(kb);
    }

    @PostMapping("/subforums")
    public SubForum createSubForum(@RequestBody SubForum subForum) {
        return subForumRepository.save(subForum);
    }

    @GetMapping("/threads")
    public List<Thread> getAllThreads() {
        return (List<Thread>) threadRepository.findAll();
    }

    @PostMapping("/threads")
    public Thread createThread(@RequestBody Thread thread) {
        return threadRepository.save(thread);
    }

    @GetMapping("/replies")
    public List<Reply> getAllReplies() {
        return (List<Reply>) replyRepository.findAll();
    }

    @PostMapping("/replies")
    public Reply createReply(@RequestBody Reply reply) {
        Reply savedReply = replyRepository.save(reply);
        // Notify thread author
        if (reply.getThread().getAuthor() != null && !reply.getThread().getAuthor().equals(reply.getAuthor())) {
            Notification notification = new Notification();
            notification.setMessage("New reply to your thread: " + reply.getThread().getTitle());
            notification.setRecipient(reply.getThread().getAuthor());
            notificationRepository.save(notification);
        }
        return savedReply;
    }

    @PostMapping("/reports")
    public Report createReport(@RequestBody Report report) {
        return reportRepository.save(report);
    }

    @PostMapping("/votes")
    public Vote createVote(@RequestBody Vote vote) {
        return voteRepository.save(vote);
    }
}