package com.ivan.work.animatedcharacter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var imageView : ImageView
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the image view for your character
        imageView = findViewById<ImageView>(R.id.character)

        firstAnimation()
    }

    fun firstAnimation(){
        // Create a new animation for your character
        val anim = TranslateAnimation(0f, 100f, 0f, 0f)
        anim.duration = 1000 // Set the duration of the animation

        // Set the animation to repeat indefinitely
        anim.repeatCount = Animation.INFINITE
        anim.repeatMode = Animation.REVERSE

        // Start the animation
        imageView.startAnimation(anim)
    }

    fun secondAnimation(){
        // Set an onClickListener for the image view
        imageView.setOnClickListener {
            isClicked = true
            // Create a new animation for your character
            val anim = ScaleAnimation(1f, 1.5f, 1f, 1.5f)
            anim.duration = 500 // Set the duration of the animation

            // Set an AnimationListener on the animation
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    // Start the first animation again when the second animation is finished
                    firstAnimation()
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })

            // Start the animation
            imageView.startAnimation(anim)
        }
    }


    fun thirdAnimation(){
        // Create a new animation for your character
        val anim = AlphaAnimation(1f, 0.5f)
        anim.duration = 1000 // Set the duration of the animation

        // Set the animation to repeat indefinitely
        anim.repeatCount = Animation.INFINITE
        anim.repeatMode = Animation.REVERSE

        // Start the animation
        imageView.startAnimation(anim)
    }

    override fun onStart() {
        super.onStart()
        secondAnimation()
        thirdAnimation()
    }

}