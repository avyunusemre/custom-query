package com.yunusky.customquery.repository;

import com.yunusky.customquery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByActiveTrue();

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findByActiveTrueJPQL();

    @Query(value = "SELECT * FROM usr WHERE active = true", nativeQuery = true)
    List<User> findByActiveTrueNative();

    List<User> findByUsernameAndActiveTrue(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.active = true")
    List<User> findByUsernameAndActiveTrueJPQL(@Param("username") String username);

    @Query(value = "SELECT * FROM usr WHERE username = :username AND active = true", nativeQuery = true)
    List<User> findByUsernameAndActiveTrueNative(@Param("username") String username);
}
