package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
