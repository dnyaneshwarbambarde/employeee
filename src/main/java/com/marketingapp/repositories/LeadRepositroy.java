package com.marketingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entities.Lead;

public interface LeadRepositroy extends JpaRepository<Lead, Long> {

}
