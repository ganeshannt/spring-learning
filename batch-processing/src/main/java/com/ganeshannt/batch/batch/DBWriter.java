package com.ganeshannt.batch.batch;

import com.ganeshannt.batch.model.User;
import com.ganeshannt.batch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
        log.info("DB writer :" + users);
        userRepository.saveAll(users);
    }
}
