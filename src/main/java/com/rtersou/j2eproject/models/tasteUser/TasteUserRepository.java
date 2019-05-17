package com.rtersou.j2eproject.models.tasteUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasteUserRepository extends JpaRepository<TasteUser, Long> {

    //List<TasteUser> findById_user(Long id);
}
