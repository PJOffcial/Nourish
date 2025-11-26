package group1.eProject.imps;

import group1.eProject.entities.Notification;
import group1.eProject.repos.NotificationRepo;
import group1.eProject.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;
    @Override
    public List<Notification> getNotifications(int userId) {
        return notificationRepo.findByUserId(userId);
    }
    @Override
    public void addNotification(Notification notification) {
        notificationRepo.save(notification);
    }
}