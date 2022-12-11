package com.example.airbnb.repository;

import com.example.airbnb.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByContentContaining(String content);

    @Modifying
    @Query(value = "select * from blog where created_at like :day", nativeQuery = true)
    Iterable<Blog> findAllByDayCreate(@Param("day") String day);

    @Modifying
    @Query(value = "select * from blog where status = 1", nativeQuery = true)
    Iterable<Blog> findAllByStatusPublic();

    Iterable<Blog> findAllByUserId(Long id);


}
