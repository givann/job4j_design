package ru.job4j.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int count = 0;
        if (previous.size() < current.size()) {
            info.setAdded(Math.abs(current.size() - previous.size()));
        } else {
            info.setDeleted(Math.abs(previous.size() - current.size()));
        }

        Map<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (map.containsKey(user.getId())) {
                if (!user.getName().equals(map.get(user.getId()))){
                    count++;
                }
            }
            map.put(user.getId(), user.getName());
        }
        info.setChanged(count);
        return info;
    }

}
