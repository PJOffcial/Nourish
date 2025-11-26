package group1.eProject.api;

import group1.eProject.entities.Notification;
import group1.eProject.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationApi {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Notification> getNotifications(@PathVariable int userId) {
        return notificationService.getNotifications(userId);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNotification(@RequestBody Notification notification) {
        notificationService.addNotification(notification);
    }
}