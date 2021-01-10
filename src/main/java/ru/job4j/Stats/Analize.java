package ru.job4j.Stats;

import javax.swing.plaf.multi.MultiSeparatorUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int del = 0;
        int chang = 0;
        Map<Integer, String> result1 = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (result1.get(user.getId()) == null) {
                del++;
            }
            if (result1.get(user.getId()) != null && !result1.get(user.getId()).equals(user.getName())) {
                chang++;

            }
        }
        info.setDeleted(del);
        info.setChanged(chang);
        info.setAdded(current.size() + del - previous.size());
        return info;
    }
}
