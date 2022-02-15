package com.myapp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
