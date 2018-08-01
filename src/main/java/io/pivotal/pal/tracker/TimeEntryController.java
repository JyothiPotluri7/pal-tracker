package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository){
        this.repository = repository;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") Long id){
        TimeEntry time = repository.find(id);
        if(time!=null){
            return new ResponseEntity<>(time, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //@PostMapping("/create")
    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry entry){
        TimeEntry time = repository.create(entry);
        return new ResponseEntity<>(time, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){
        List time = repository.list();
        return new ResponseEntity<List<TimeEntry>>(time, HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") Long id,@RequestBody TimeEntry entry){
        TimeEntry time = repository.update(id, entry);
        if(time!=null) {
            //TimeEntry time = repository.update(id, entry);
            return new ResponseEntity<>(time, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry>  delete(@PathVariable("id") Long id){
        //repository.delete(id);
        repository.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        //return new ResponseEntity<>(time, HttpStatus.OK);
    }



}
