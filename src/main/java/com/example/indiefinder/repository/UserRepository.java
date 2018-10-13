package com.example.indiefinder.repository;

        import com.example.indiefinder.entities.UserEntity;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
