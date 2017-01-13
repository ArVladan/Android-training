package promo.kit.provokator;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.anima);
        frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.setOneShot(false);
        frameAnimation.start();

    }
    public void startArsenal(View view) {
        //frameAnimation.stop();
        Intent intent = new Intent(MainActivity.this, ArsenalActivity.class);
        startActivity(intent);
    }



}
