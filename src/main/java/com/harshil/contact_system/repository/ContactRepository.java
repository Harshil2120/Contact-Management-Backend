package com.harshil.contact_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshil.contact_system.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>{

}
