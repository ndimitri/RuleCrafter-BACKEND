package be.storm.rulecrafterbackend.dal.repositories;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username ilike :username")
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.email ilike :email")
    Optional<User> findByEmail(String email);

    @Query("select count(u) > 0 from User u where u.email ilike :email")
    boolean existsByEmail(String email);

    @Query("select count(u) > 0 from User u where u.username ilike :username or u.email ilike :email")
    boolean existsByUsernameOrEmail(String username, String email);
}

//todo query
