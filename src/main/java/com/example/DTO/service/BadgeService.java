package com.example.DTO.service;

import com.example.DTO.entity.Badge;
import com.example.DTO.entity.Role;
import com.example.DTO.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> getBadges() {
        return (List<Badge>) badgeRepository.findAll();
    }

    public Optional<Badge> getBadgeById(Integer id) {
        return badgeRepository.findById(id);
    }

    public List<Badge> getBadgeContaining(String expression) {
        return badgeRepository.findByNameContaining(expression);
    }

    public Badge saveBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    public void deleteBadgeById(Integer id) {
        badgeRepository.deleteById(id);
    }
}
