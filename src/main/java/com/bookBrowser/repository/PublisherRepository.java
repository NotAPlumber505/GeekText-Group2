package com.bookBrowser.repository;

import com.bookBrowser.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
