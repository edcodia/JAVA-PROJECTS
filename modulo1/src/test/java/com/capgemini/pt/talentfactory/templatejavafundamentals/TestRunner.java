package com.capgemini.pt.talentfactory.templatejavafundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class TestRunner {
    @Test
    public void testCreateOneInvoice() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("1\ni1\na1\n123\n\n2\ni1\n3\n".getBytes()));
        Runner runner = new Runner(new RestauranteService());
        try {
            runner.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(1, runner.getAllRestaurantes());
        System.setIn(stdin);
    }
}