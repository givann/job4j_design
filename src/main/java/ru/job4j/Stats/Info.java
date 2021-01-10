package ru.job4j.Stats;

public class Info {
    private int added;
    private int changed;
    private int deleted;

    public int getAdded() {
        return added;
    }

    public int setAdded(int added) {
        this.added = added;
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public int setDeleted(int deleted) {
        this.deleted = deleted;
        return deleted;
    }
}
