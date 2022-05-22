package com.ganeshannt.batch.batch;

import com.ganeshannt.batch.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPARTMENT_MAP = new HashMap<>();

    public Processor() {
        DEPARTMENT_MAP.put("001", "ENGINEERING");
        DEPARTMENT_MAP.put("002", "LOGISTICS");
        DEPARTMENT_MAP.put("003", "CONSTRUCTION");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDepartment();
        String dept = DEPARTMENT_MAP.get(deptCode);
        user.setDepartment(dept);
        log.info("Item processor :" + user);
        return user;
    }
}
