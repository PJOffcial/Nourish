package group1.eProject.services;

import group1.eProject.entities.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getNotifications(int userId);
    void addNotification(Notification notification);
}