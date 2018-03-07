package com.gunjal.prahlad.prahladgunjal;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.gunjal.prahlad.prahladgunjal.*;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.R.transition.fade;

public class
fab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);



        LinearLayout one =           (LinearLayout) findViewById(R.id.top);
        		
		LinearLayout two =(LinearLayout)  findViewById(R.id.center);
        LinearLayout three =  findViewById(R.id.bottom);
        FrameLayout d =  findViewById(R.id.fab4);
        FrameLayout c =  findViewById(R.id.fab3);
        FrameLayout b =  findViewById(R.id.fab2);
        FrameLayout a = findViewById(R.id.fab1);
        Animation adone1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation adone5 = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation adone6 = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation adone7 = AnimationUtils.loadAnimation(this, R.anim.translate);
        adone1.setStartOffset(300);
        adone5.setStartOffset(300);
        adone6.setStartOffset(300);
        adone7.setStartOffset(300);

        one.startAnimation(adone1);

        two.startAnimation(adone1);

        three.startAnimation(adone1);

        a.startAnimation(adone7);
        b.startAnimation(adone7);
        c.startAnimation(adone7);
        d.startAnimation(adone7);



    FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);
        if (savedInstanceState == null) {
        rootLayout.setVisibility(View.INVISIBLE);

        ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);
                    enterReveal();
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        rootLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }






       /* Animation adone = AnimationUtils.loadAnimation(this, R.anim.scale);
        adone.setStartOffset(0);
        Animation adone2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        adone2.setStartOffset(100);
        Animation adone3 = AnimationUtils.loadAnimation(this, R.anim.scale);
        adone3.setStartOffset(200);
        Animation adone4 = AnimationUtils.loadAnimation(this, R.anim.scale);
        adone4.setStartOffset(300);*/



    }

    private void enterReveal() {

        FrameLayout fab;
        fab = (FrameLayout) findViewById(R.id.fab1);

        FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);

                int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        //int cx = (int) (fab.getX() + (fab.getWidth()/2));
       // int cy = (int) (fab.getY())+ fab.getHeight() + 56;



          int cx = rootLayout.getWidth() ;
         int cy = rootLayout.getHeight() ;

        //LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

        //int cx = rootLayout.getWidth() / 2;
        //int cy = rootLayout.getHeight() / 2;

       // float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx  ,cy  , 0, endRadius);
        circularReveal.setDuration(800);

        // make the view visible and start the animation
        rootLayout.setVisibility(View.VISIBLE);
        circularReveal.start();
    }

    @Override
    public void onBackPressed(){
        FrameLayout fab;
        fab = (FrameLayout) findViewById(R.id.fab1);

        final FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);

        int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        //int cx = (int) (fab.getX() + (fab.getWidth()/2));
        // int cy = (int) (fab.getY())+ fab.getHeight() + 56;



        int cx = rootLayout.getWidth() ;
        int cy = rootLayout.getHeight() ;

        //LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

        //int cx = rootLayout.getWidth() / 2;
        //int cy = rootLayout.getHeight() / 2;

        // float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx  ,cy  , endRadius , 0);
        circularReveal.setDuration(300);

        // make the view visible and start the animation
        // make the view invisible when the animation is done
        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                overridePendingTransition(fade, fade);
                finish();

                rootLayout.setVisibility(View.INVISIBLE);
            }
        });

// start the animation
        circularReveal.start();

    }

public void back(View view){
    Log.i("h", "see");
    FrameLayout fab;
    fab = (FrameLayout) findViewById(R.id.fab1);

    final FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);

    int w = rootLayout.getWidth();
    int h = rootLayout.getHeight();

    int endRadius = (int) Math.hypot(w, h);

    //int cx = (int) (fab.getX() + (fab.getWidth()/2));
    // int cy = (int) (fab.getY())+ fab.getHeight() + 56;



    int cx = rootLayout.getWidth() ;
    int cy = rootLayout.getHeight() ;

    //LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

    //int cx = rootLayout.getWidth() / 2;
    //int cy = rootLayout.getHeight() / 2;

    // float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

    // create the animator for this view (the start radius is zero)
    Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx  ,cy  , endRadius , 0);
    circularReveal.setDuration(200);

    // make the view visible and start the animation
    // make the view invisible when the animation is done
    circularReveal.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);

            overridePendingTransition(fade, fade);
            finish();

            rootLayout.setVisibility(View.INVISIBLE);
        }
    });

// start the animation
    circularReveal.start();

}

    public void back1(View view){
        Log.i("h", "see");
        FrameLayout fab;
        fab = (FrameLayout) findViewById(R.id.fab1);

        final FrameLayout rootLayout = (FrameLayout) findViewById(R.id.fabsurface);

        int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        //int cx = (int) (fab.getX() + (fab.getWidth()/2));
        // int cy = (int) (fab.getY())+ fab.getHeight() + 56;



        int cx = rootLayout.getWidth() ;
        int cy = rootLayout.getHeight() ;

        //LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

        //int cx = rootLayout.getWidth() / 2;
        //int cy = rootLayout.getHeight() / 2;

        // float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx  ,cy  , endRadius , 0);
        circularReveal.setDuration(200);

        // make the view visible and start the animation
        // make the view invisible when the animation is done
        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                overridePendingTransition(fade, fade);
                finish();

                rootLayout.setVisibility(View.INVISIBLE);
            }
        });

// start the animation
        circularReveal.start();

    }

public void web (View view)
{
    String url1 = "https://secuzer.tk";
    Intent i1 = new Intent(Intent.ACTION_VIEW);
    i1.setData(Uri.parse(url1));
    startActivity(i1);
}

    public void call(View view){

                Intent callIntent = new Intent(Intent.ACTION_VIEW);
                callIntent.setData(Uri.parse("tel:9736066176"));

                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                startActivity(callIntent);

    }
    public void facebook(View view){
        String url = "https://www.facebook.com/shivam.kapila.1?ref=br_rs";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void twitter(View view){
        String url = "https://twitter.com/ThisIsNSH";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void locate(View view){

        String url = "https://www.google.co.in/maps/place/Kailash+Boys+Hostel/@31.7089206,76.5238424,17.04z/data=!4m8!1m2!2m1!1skbh+nit+hamirpur!3m4!1s0x0:0x5b0a8b8b6c508646!8m2!3d31.7104267!4d76.5266941?hl=en";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
                startActivity(i);

    }
}
