package group1.eProject.api;

import group1.eProject.entities.Profile;
import group1.eProject.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileApi {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Profile> getProfiles() {
        return profileService.findAll();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.save(profile);
    }
}