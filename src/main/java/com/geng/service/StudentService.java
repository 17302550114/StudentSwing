package com.geng.service;

import com.geng.req.StudnetRequest;
import com.geng.res.TableDTO;

public interface StudentService {
    TableDTO retrieveStudents(StudnetRequest request);
}
