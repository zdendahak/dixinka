package cz.hak.zdenek.dixinkawebapp.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class HobbyTest {

    Hobby hobby;

    @Before
    public void setUp(){
        hobby = new Hobby();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        hobby.setId(idValue);

        assertEquals(idValue, hobby.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getAccounts() throws Exception {
    }

}