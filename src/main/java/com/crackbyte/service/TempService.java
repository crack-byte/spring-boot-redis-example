package com.crackbyte.service;

import com.crackbyte.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TempService {
    private final HashOperations<String, Object, Object> hashOperations;

    public TempService(RedisTemplate<String, User> redisTemplate) {
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(User user) {
        log.info("{}", user);
        hashOperations.putIfAbsent("user", user.getId(), user);
    }

    public Object findById(String id) {
        return hashOperations.get("user", id);
    }
}
