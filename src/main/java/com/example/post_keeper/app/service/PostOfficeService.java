package com.example.post_keeper.app.service;

import com.example.post_keeper.app.entity.PostOfficeEntity;
import com.example.post_keeper.app.repository.PostOfficeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public void processPostOffices(List<PostOfficeEntity> toModelList) {
        try {
            postOfficeRepository.saveAll(toModelList);
        } catch (DataIntegrityViolationException ignored) {
        }
    }

    public List<PostOfficeEntity> getOffices() {
        return postOfficeRepository.findAll();
    }
}
