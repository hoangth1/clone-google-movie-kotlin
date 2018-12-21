package clone.hoang.com.myapplication.screen.ui.activity

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.ActionBarDrawerToggle
import clone.hoang.com.myapplication.R
import clone.hoang.com.myapplication.screen.ui.base.BaseActivity
import clone.hoang.com.myapplication.screen.ui.fragment.main.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().apply {
                add(R.id.container, MainFragment.newInstance(), "")
                commit()
            }
        ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name, R.string.app_name).apply {
            drawerArrowDrawable.color = ResourcesCompat.getColor(resources, R.color.mercury, null)
            drawer_layout.addDrawerListener(this)
            syncState()
        }
    }
}
