package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Category;


@Repository
public interface CateRepo extends JpaRepository<Category, Integer>{

}
