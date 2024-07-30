package org.xedox.paide;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import processing.android.PFragment;
import processing.core.PApplet;

public class PreviewActivity extends AppCompatActivity {

    private Sketch sketch;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview); // Set content view before adding fragment

        sketch = new Sketch();
        frame = findViewById(R.id.frame_preview); 

        PFragment fragment = new PFragment(sketch);
        getSupportFragmentManager().beginTransaction().replace(frame.getId(), fragment).commit();
    }
}

class Sketch extends PApplet {

    @Override
    public void setup() {
        fullScreen(P2D);
    }

    @Override
    public void draw() {

        background(0);
        ellipse(width / 2, height / 2, 200, 200);
    }
}