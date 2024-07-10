package com.basic.controller;

import com.basic.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/health-check")
    public String healthCheck(){
        return  "Ok";
    }

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(),entry);
        return true;
    }

    @GetMapping("/{id}")
    public JournalEntry getJournalEntry(@PathVariable Long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("/{id}")
    public JournalEntry deleteJournalEntry(@PathVariable Long id){
        return journalEntries.remove(id);
    }
}
