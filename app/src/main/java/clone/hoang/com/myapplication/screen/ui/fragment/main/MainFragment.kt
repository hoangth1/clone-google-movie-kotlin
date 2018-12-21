package clone.hoang.com.myapplication.screen.ui.fragment.main

import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import clone.hoang.com.myapplication.R
import clone.hoang.com.myapplication.databinding.FragmentMainBinding
import clone.hoang.com.myapplication.screen.ui.activity.MainActivity
import clone.hoang.com.myapplication.screen.ui.base.BaseFragment
import com.android.databinding.library.baseAdapters.BR
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override val bindingVariable: Int = BR.viewModel
    override val viewModel: MainViewModel by viewModel()
    override val layoutRes: Int = R.layout.fragment_main
    override fun initComps() {
        setHasOptionsMenu(true)
        (activity as MainActivity).apply {
            val firstPart = SpannableString(getString(R.string.google_play))
            val lastPart = SpannableString(getString(R.string.movie_and_tv))

            firstPart.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(applicationContext, R.color.mercury)),
                0,
                firstPart.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            lastPart.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(applicationContext, R.color.colorAccent)),
                0,
                lastPart.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            supportActionBar?.title = TextUtils.concat(firstPart, " ", lastPart)

        }
    }
}
