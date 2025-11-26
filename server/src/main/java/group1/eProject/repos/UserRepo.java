package group1.eProject.repos;

import group1.eProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer>{
    @Query("select a from Account a where (a.username=:identifier or a.email=:identifier or a.phone=:identifier) and a.password=:password")
    User login(String identifier, String password);

}