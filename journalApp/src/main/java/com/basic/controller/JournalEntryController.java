package com.basic.controller;

import com.basic.entity.JournalEntry;
import com.basic.service.JournalEntryService;
import com.basic.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	private JournalEntryService journalEntryService;
	@Autowired
	private UserService userService;

	public JournalEntryController(JournalEntryService journalEntryService) {
		this.journalEntryService = journalEntryService;
	}

	@GetMapping
	public ResponseEntity<List<JournalEntry>> getAll() {
		try {
			return ResponseEntity.ok(journalEntryService.getAll());
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry) {
		try {
			entry.setDate(LocalDateTime.now());
			journalEntryService.saveEntry(entry);
			return new ResponseEntity<>(entry, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<JournalEntry> getJournalEntry(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(journalEntryService.getJournal(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<JournalEntry> updateJournalEntry(@RequestBody JournalEntry journalEntry,
			@PathVariable Long id) {
		try {
			return ResponseEntity.ok(journalEntryService.updateJournal(journalEntry, id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJournalEntry(@PathVariable Long id) {
		try {
			journalEntryService.deleteJournal(id);
			return new ResponseEntity<>("Journal Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
