package com.berkayesen.meup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.animation.AnimationUtils
import com.berkayesen.meup.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            teamLiquidIv.alpha = 0f
            val rotateAnimation = AnimationUtils.loadAnimation(this@SplashActivity.applicationContext, R.anim.rotate)
            binding.teamLiquidIv.startAnimation(rotateAnimation)

            binding.teamLiquidIv.animate().setDuration(4000).alpha(1f).withEndAction {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
}