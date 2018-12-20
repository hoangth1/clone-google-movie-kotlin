package clone.hoang.com.myapplication.screen.ui.fragment.main

import clone.hoang.com.myapplication.R
import clone.hoang.com.myapplication.databinding.FragmentMainBinding
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
    }

}