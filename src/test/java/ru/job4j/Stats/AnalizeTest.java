package ru.job4j.Stats;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest extends TestCase {

    @Test
    public void testDiffAdd() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Tom"));
        prev.add(new User(2, "Sam"));
        prev.add(new User(3, "John"));
        List<User> cur = new ArrayList<>();
        cur.add(new User(1, "Tom"));
        cur.add(new User(2, "Samm"));
        cur.add(new User(3, "Samy"));
        cur.add(new User(4, "Same"));
        cur.add(new User(5, "Saman"));
        Analize analize = new Analize();
        int expRes = 2;
        int actRes = analize.diff(prev,cur).getAdded();
        assertThat(actRes,is(expRes));
    }

    @Test
    public void testDiffDel() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Tom"));
        prev.add(new User(2, "Sam"));
        prev.add(new User(3, "John"));
        prev.add(new User(4, "Same"));
        prev.add(new User(5, "Saman"));
        List<User> cur = new ArrayList<>();
        cur.add(new User(1, "Tom"));
        cur.add(new User(2, "Samm"));
        cur.add(new User(3, "Samy"));
        Analize analize = new Analize();
        int expRes = 2;
        int actRes = analize.diff(prev,cur).getDeleted();
        assertThat(actRes,is(expRes));
    }

    @Test
    public void testDiffChan() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Tom"));
        prev.add(new User(2, "Sam"));
        prev.add(new User(3, "John"));
        List<User> cur = new ArrayList<>();
        cur.add(new User(1, "Tom"));
        cur.add(new User(2, "Sam"));
        cur.add(new User(3, "Samy"));
        Analize analize = new Analize();
        int expRes = 1;
        int actRes = analize.diff(prev,cur).getChanged();
        assertThat(actRes,is(expRes));
    }
}