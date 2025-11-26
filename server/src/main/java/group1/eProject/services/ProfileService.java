package group1.eProject.services;

import group1.eProject.entities.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> findAll();
    Profile save(Profile profile);
}