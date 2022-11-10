package com.demo123.demo.service;

import com.demo123.demo.model.Classroom;
import com.demo123.demo.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomServiceImpl implements IClassroomService {

    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAll() {
        return null;
    }

    @Override
    public Optional<Classroom> findById(Integer id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
