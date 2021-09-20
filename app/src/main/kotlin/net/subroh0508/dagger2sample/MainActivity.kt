package net.subroh0508.dagger2sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.subroh0508.dagger2sample.databinding.ActivityMainBinding
import net.subroh0508.dagger2sample.legacy.dagger.SearchAnimeWithDaggerActivity
import net.subroh0508.dagger2sample.legacy.daggerandroid.SearchAnimeWithDaggerAndroidActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) = with (binding) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        openLegacyDagger.setOnClickListener { open<SearchAnimeWithDaggerActivity>() }
        openLegacyDaggerAndroid.setOnClickListener { open<SearchAnimeWithDaggerAndroidActivity>() }
        openLegacyDaggerHilt.setOnClickListener {}
        openComposeDagger.setOnClickListener {}
        openComposeDaggerAndroid.setOnClickListener {}
        openComposeDaggerHilt.setOnClickListener {}
    }

    private inline fun <reified V: AppCompatActivity> open() = startActivity(
        Intent(this, V::class.java)
    )
}
