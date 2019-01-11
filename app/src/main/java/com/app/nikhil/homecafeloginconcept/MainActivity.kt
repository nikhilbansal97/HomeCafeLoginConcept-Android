package com.app.nikhil.homecafeloginconcept

import android.animation.AnimatorSet
import android.animation.FloatEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var chefImageYAxisAnimator: ObjectAnimator
    private lateinit var chefImageAlphaAnimator: ValueAnimator
    private lateinit var chefLoginAnimatorSet: AnimatorSet
    private lateinit var loginMarginAnimator: ValueAnimator
    private lateinit var loginAlphaAnimator: ValueAnimator
    private lateinit var signupMarginAnimator: ValueAnimator
    private lateinit var signupAlphaAnimator: ValueAnimator
    private lateinit var connectWithAlphaAnimator: ValueAnimator
    private lateinit var instagramAnimator: ValueAnimator
    private lateinit var vkAnimator: ValueAnimator
    private lateinit var googleAnimator: ValueAnimator
    private lateinit var facebookAnimator: ValueAnimator
    private val animationDuration = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chefImageYAxisAnimator = ObjectAnimator.ofObject(chefImageContainer, "translationY", FloatEvaluator(), 300F, 500F).apply {
            duration = animationDuration
        }
        chefImageYAxisAnimator.interpolator = AccelerateDecelerateInterpolator()

        chefImageAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = animationDuration
            addUpdateListener {
                chefImageContainer.alpha = it.animatedValue as Float
            }
        }

        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        loginMarginAnimator = ValueAnimator.ofInt(20, 80).apply {
            duration = 500
            addUpdateListener {
                params.topMargin = it.animatedValue as Int
                params.leftMargin = 50
                params.rightMargin = 50
                loginButton.layoutParams = params
            }
        }

        loginAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 500
            addUpdateListener {
                loginButton.alpha = it.animatedValue as Float
            }
        }

        val signUpParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        signupMarginAnimator = ValueAnimator.ofInt(10, 60).apply {
            duration = 500
            addUpdateListener {
                signUpParams.topMargin = it.animatedValue as Int
                signUpParams.leftMargin = 50
                signUpParams.rightMargin = 50
                signUpButton.layoutParams = signUpParams
            }
        }

        signupAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 500
            addUpdateListener {
                signUpButton.alpha = it.animatedValue as Float
            }
        }

        connectWithAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 200
            addUpdateListener {
                connectWithLayout.alpha = it.animatedValue as Float
            }
        }

        val instagramMargin = LinearLayout.LayoutParams(0, 100)
        instagramAnimator = ValueAnimator.ofInt(-40, 80).apply {
            duration = 200
            addUpdateListener {
                instagramMargin.bottomMargin = it.animatedValue as Int
                instagramMargin.weight = 1f
                instagramImage.layoutParams = instagramMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val vkMargin = LinearLayout.LayoutParams(0, 100)
        vkAnimator = ValueAnimator.ofInt(-40, 80).apply {
            duration = 200
            addUpdateListener {
                vkMargin.bottomMargin = it.animatedValue as Int
                vkMargin.weight = 1f
                vkImage.layoutParams = vkMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val googleMargin = LinearLayout.LayoutParams(0, 100)
        googleAnimator = ValueAnimator.ofInt(-40, 80).apply {
            duration = 200
            addUpdateListener {
                googleMargin.bottomMargin = it.animatedValue as Int
                googleMargin.weight = 1f
                googleImage.layoutParams = googleMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val fbMargin = LinearLayout.LayoutParams(0, 100)
        facebookAnimator = ValueAnimator.ofInt(-40, 80).apply {
            duration = 200
            addUpdateListener {
                fbMargin.bottomMargin = it.animatedValue as Int
                fbMargin.weight = 1f
                facebookImage.layoutParams = fbMargin
            }
            interpolator = DecelerateInterpolator()
        }

        chefLoginAnimatorSet = AnimatorSet().apply {
            play(chefImageAlphaAnimator).with(chefImageYAxisAnimator)
            play(loginMarginAnimator).with(loginAlphaAnimator).after(800)
            play(signupMarginAnimator).with(signupAlphaAnimator).after(1100)
            play(connectWithAlphaAnimator).after(1300)
            play(instagramAnimator).after(1500)
            play(vkAnimator).after(1600)
            play(googleAnimator).after(1700)
            play(facebookAnimator).after(1800)
        }
    }

    override fun onResume() {
        super.onResume()
        chefLoginAnimatorSet.start()
    }
}
