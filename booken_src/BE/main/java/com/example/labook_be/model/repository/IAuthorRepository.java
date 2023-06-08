package com.example.labook_be.model.repository;

import com.example.labook_be.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAuthorRepository extends JpaRepository<Author, Integer> {

    @Query(
        value = " select * from author ", nativeQuery = true
    )
    List<Author> getAuthorList();

}
