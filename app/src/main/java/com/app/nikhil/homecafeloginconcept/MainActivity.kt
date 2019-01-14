package com.app.nikhil.homecafeloginconcept

import android.animation.*
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

        loginButton.setOnClickListener { showLoginFormAnimation() }

        chefImageYAxisAnimator = ObjectAnimator.ofObject(chefImageContainer, "translationY", FloatEvaluator(), 300F, 500F).apply {
            duration = animationDuration
            interpolator = AccelerateDecelerateInterpolator()
        }

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
                params.leftMargin = 80
                params.rightMargin = 80
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
                signUpParams.leftMargin = 80
                signUpParams.rightMargin = 80
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

        chefLoginAnimatorSet.start()
    }

    private fun showLoginFormAnimation() {
        val reverseAnimatorSet = AnimatorSet()

        signupAlphaAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            duration = 500
            addUpdateListener {
                signUpButton.alpha = it.animatedValue as Float
            }
        }

        val instagramMargin = LinearLayout.LayoutParams(0, 100)
        instagramAnimator = ValueAnimator.ofInt(80, -90).apply {
            duration = 200
            addUpdateListener {
                instagramMargin.bottomMargin = it.animatedValue as Int
                instagramMargin.weight = 1f
                instagramImage.layoutParams = instagramMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val vkMargin = LinearLayout.LayoutParams(0, 100)
        vkAnimator = ValueAnimator.ofInt(80, -90).apply {
            duration = 200
            addUpdateListener {
                vkMargin.bottomMargin = it.animatedValue as Int
                vkMargin.weight = 1f
                vkImage.layoutParams = vkMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val googleMargin = LinearLayout.LayoutParams(0, 100)
        googleAnimator = ValueAnimator.ofInt(80, -90).apply {
            duration = 200
            addUpdateListener {
                googleMargin.bottomMargin = it.animatedValue as Int
                googleMargin.weight = 1f
                googleImage.layoutParams = googleMargin
            }
            interpolator = DecelerateInterpolator()
        }

        val fbMargin = LinearLayout.LayoutParams(0, 100)
        facebookAnimator = ValueAnimator.ofInt(80, -90).apply {
            duration = 200
            addUpdateListener {
                fbMargin.bottomMargin = it.animatedValue as Int
                fbMargin.weight = 1f
                facebookImage.layoutParams = fbMargin
            }
            interpolator = DecelerateInterpolator()
        }

        connectWithAlphaAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            duration = 200
            addUpdateListener {
                connectWithLayout.alpha = it.animatedValue as Float
            }
        }

        val passwordParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        val passwordHeightAnimator = ValueAnimator.ofInt(0, 170).apply {
            duration = 1000
            addUpdateListener {
                passwordParams.apply {
                    leftMargin = 80
                    rightMargin = 80
                    height = it.animatedValue as Int
                }
                passwordContainer.layoutParams = passwordParams
            }
            interpolator = AccelerateDecelerateInterpolator()
        }
        val passwordAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener {
                passwordContainer.apply {
                    alpha = it.animatedValue as Float
                }
            }
            interpolator = AccelerateDecelerateInterpolator()
        }

        val emailParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        val emailHeightAnimator = ValueAnimator.ofInt(0, 120).apply {
            duration = 1000
            addUpdateListener {
                emailParams.apply {
                    leftMargin = 80
                    rightMargin = 80
                    height = it.animatedValue as Int
                }
                emailEditText.layoutParams = emailParams
            }
        }

        val emailAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener {
                emailEditText.alpha = it.animatedValue as Float
            }
        }

        chefImageYAxisAnimator = ObjectAnimator.ofObject(chefImageContainer, "translationY", FloatEvaluator(), 500F, 200F).apply {
            duration = animationDuration
            interpolator = AccelerateDecelerateInterpolator()
        }

        val chefLayoutParams = chefImage.layoutParams as LinearLayout.LayoutParams
        val chefBoundsAnimator = ValueAnimator.ofInt(4, 4).apply {
            duration = 400
            addUpdateListener {
                chefLayoutParams.apply {
                    height -= it.animatedValue as Int
                    width -= it.animatedValue as Int
                    bottomMargin += (it.animatedValue as Int) * 2
                }
                chefImage.layoutParams = chefLayoutParams
            }
        }

        reverseAnimatorSet.apply {
            play(signupAlphaAnimator)
            play(instagramAnimator).after(300)
            play(vkAnimator).with(connectWithAlphaAnimator).after(400)
            play(chefImageYAxisAnimator).with(chefBoundsAnimator).after(500)
            play(passwordAlphaAnimator).with(passwordHeightAnimator).with(googleAnimator).after(700)
            play(emailHeightAnimator).with(emailAlphaAnimator).after(passwordAlphaAnimator)
            play(facebookAnimator).after(800)
        }

        reverseAnimatorSet.start()
        loginButton.setOnClickListener { showWelcomeAnimation() }
    }

    private fun showWelcomeAnimation() {
        val emailAlphaAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            duration = 200
            addUpdateListener {
                emailEditText.alpha = it.animatedValue as Float
            }
        }

        val passwordAlphaAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            duration = 200
            addUpdateListener {
                passwordContainer.apply {
                    alpha = it.animatedValue as Float
                }
            }
            interpolator = AccelerateDecelerateInterpolator()
        }

        loginAlphaAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            duration = 200
            addUpdateListener {
                loginButton.alpha = it.animatedValue as Float
            }
        }

        chefImageYAxisAnimator = ObjectAnimator.ofObject(chefImageContainer, "translationY", FloatEvaluator(),  600F).apply {
            duration = 1500
            interpolator = AccelerateDecelerateInterpolator()
        }

        val chefLayoutParams = chefImage.layoutParams as LinearLayout.LayoutParams
        val chefBoundsAnimator = ValueAnimator.ofInt(1, 1).apply {
            duration = 1500
            addUpdateListener {
                chefLayoutParams.apply {
                    height += it.animatedValue as Int
                    width += it.animatedValue as Int
                }
                chefImage.layoutParams = chefLayoutParams
            }
            interpolator = AccelerateDecelerateInterpolator()
        }

        val welcomeTextBounds = welcomeTextView.layoutParams as LinearLayout.LayoutParams
        val welcomeTextAnimator = ValueAnimator.ofInt(welcomeTextBounds.height, 200).apply {
            duration = 50
            addUpdateListener {
                welcomeTextBounds.height = it.animatedValue as Int
                welcomeTextView.layoutParams = welcomeTextBounds
            }
            interpolator = AccelerateDecelerateInterpolator()
        }

        val welcomeAlphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener {
                welcomeTextView.alpha = it.animatedValue as Float
            }
            interpolator = AccelerateDecelerateInterpolator()
        }

        val chefParams = chefImage.layoutParams as LinearLayout.LayoutParams
        val chefImageMarginAnimator = ValueAnimator.ofInt(chefParams.bottomMargin, 10).apply {
            duration = 50
            addUpdateListener {
                chefParams.bottomMargin = it.animatedValue as Int
                chefImage.layoutParams = chefParams
            }
        }

        val welcomeAnimatorSet = AnimatorSet()
        welcomeAnimatorSet.apply {
            playSequentially(emailAlphaAnimator, passwordAlphaAnimator, loginAlphaAnimator)
            play(chefImageYAxisAnimator).with(chefBoundsAnimator).after(loginAlphaAnimator)
            play(welcomeAlphaAnimator).with(welcomeTextAnimator).with(chefImageMarginAnimator).after(chefImageYAxisAnimator)
        }
        welcomeAnimatorSet.start()
    }
}
