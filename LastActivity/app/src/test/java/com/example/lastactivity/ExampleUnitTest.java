package com.example.lastactivity;

import android.widget.Toast;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        Toast.makeText(getContext(), "2233", Toast.LENGTH_SHORT).show();
        Button button =(Button) findViewById(R.id.button);
    }
}