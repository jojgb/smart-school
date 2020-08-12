package com.example.smartspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartspring.model.GuruModel;

public interface GuruRepository extends JpaRepository<GuruModel, String> {

}
