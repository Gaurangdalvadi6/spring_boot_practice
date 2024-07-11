package com.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.entity.JournalEntry;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

}
