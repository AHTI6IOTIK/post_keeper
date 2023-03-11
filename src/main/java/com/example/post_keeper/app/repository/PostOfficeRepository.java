package com.example.post_keeper.app.repository;

import com.example.post_keeper.app.entity.PostOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepository extends JpaRepository<PostOfficeEntity, Long> {
}
