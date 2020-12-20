package com.geng.service;

import com.geng.entity.StudentDO;
import com.geng.req.StudnetRequest;
import com.geng.res.TableDTO;

public interface StudentService {
    TableDTO retrieveStudents(StudnetRequest request);

    boolean add(StudentDO studentDO);
}
