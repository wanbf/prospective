package com.prospective.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl {

    @Transactional(propagation = Propagation.SUPPORTS,
            isolation = Isolation.READ_COMMITTED,
            noRollbackFor = {RuntimeException.class})
    public int add() {
        return 0;
    }

}
