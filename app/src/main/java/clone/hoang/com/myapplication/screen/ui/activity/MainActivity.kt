package clone.hoang.com.myapplication.screen.ui.activity

import android.os.Bundle
import clone.hoang.com.myapplication.R
import clone.hoang.com.myapplication.screen.ui.base.BaseActivity
import clone.hoang.com.myapplication.screen.ui.fragment.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().apply {
                add(R.id.root_contaier, MainFragment.newInstance(), "")
                commit()
            }
    }
}
