package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry time);
    public TimeEntry find(Long id);
    public TimeEntry update(Long id, TimeEntry time);
    public void delete(Long id);
    public List list();
}
