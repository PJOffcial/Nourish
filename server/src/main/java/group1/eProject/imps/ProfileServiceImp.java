package group1.eProject.imps;

import group1.eProject.entities.Profile;
import group1.eProject.repos.ProfileRepo;
import group1.eProject.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImp implements ProfileService {
    @Autowired
    private ProfileRepo profileRepo;
    @Override
    public List<Profile> findAll() {
        return profileRepo.findAll();
    }
    @Override
    public Profile save(Profile profile) {
        return profileRepo.save(profile);
    }
}