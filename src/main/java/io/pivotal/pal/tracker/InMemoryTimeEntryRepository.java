package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long,TimeEntry> map = new HashMap<>();


    @Override
    public TimeEntry create(TimeEntry time) {
        //System.out.println("TEST " + time.getId());
        Long id = map.size() + 1L;
        TimeEntry timeEntry = new TimeEntry(id,time.getProjectId(),time.getUserId(),time.getDate(),time.getHours());
        map.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return map.get(id);
    }


    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
       TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        map.replace(id, updatedEntry);
        return updatedEntry;

    }

    @Override
    public TimeEntry delete(Long id) {
        TimeEntry entry = map.get(id);
        map.remove(id);
        return entry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(map.values());
    }
}
