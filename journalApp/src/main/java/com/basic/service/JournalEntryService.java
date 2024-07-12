package com.basic.service;

import com.basic.entity.JournalEntry;
import com.basic.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalEntryService {

    private JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return  journalEntryRepository.findAll();
    }

    public JournalEntry getJournal(Long id){
        return journalEntryRepository.findById(id).orElseThrow(()-> new RuntimeException("Journal Not Found : "+id));
    }

    public  JournalEntry updateJournal(JournalEntry journalEntry, Long id){
        JournalEntry journalEntry1 = journalEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal Not Found : " + id));
        journalEntry1.setContent(journalEntry.getContent());
        journalEntry1.setTitle(journalEntry.getTitle());
        journalEntry1.setDate(LocalDateTime.now());
        journalEntry1.setUser(journalEntry.getUser());

        return journalEntryRepository.save(journalEntry1);
    }

    public boolean deleteJournal(Long id){
        JournalEntry journalEntry1 = journalEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal Not Found : " + id));
        journalEntryRepository.delete(journalEntry1);
        return  true;
    }

}
