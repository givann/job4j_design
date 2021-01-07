package ru.job4j.Stats;

import java.util.ArrayList;
import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int count = 0;
        if (previous.size() < current.size()) {
            info.setAdded(Math.abs(current.size() - previous.size()));
        } else {
            info.setDeleted(Math.abs(previous.size() - current.size()));
        }
        for (User user : previous) {
            for (User user1 : current) {
                if (user.getId() == user1.getId()) {
                    if (!user.getName().equals(user1.getName())) {
                        count++;
                    }
                }
            }
        }
        info.setChanged(count);
        return info;
    }
}
