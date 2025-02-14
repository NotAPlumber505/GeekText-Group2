package com.geektext.repository;

import com.geektext.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
