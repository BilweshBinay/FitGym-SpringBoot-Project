package com.example.fitgym.repository;

import com.example.fitgym.entity.AdminEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    Optional<AdminEntity> findByAdminEmail(String adminEmail);

    @Modifying
    @Transactional
    @Query("UPDATE AdminEntity a SET a.adminOtp =:otp WHERE a.adminEmail =:email")
    void updateAdminOtp(@Param("email") String email, @Param("otp") String otp);
}
