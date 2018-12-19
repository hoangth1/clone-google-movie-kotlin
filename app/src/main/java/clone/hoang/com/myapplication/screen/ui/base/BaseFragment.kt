package clone.hoang.com.myapplication.screen.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import clone.hoang.com.myapplication.R

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {
    abstract val bindingVariable: Int
    abstract val viewModel: ViewModel
    abstract val layoutRes: Int
    lateinit var viewBinding: ViewBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewBinding.apply {
            setLifecycleOwner(this@BaseFragment)
            setVariable(bindingVariable, viewModel)
            executePendingBindings()
        }
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    open fun onBack() {
        activity?.onBackPressed()
    }

    fun addFragment(fragment: Fragment, TAG: String?, addToBackStack: Boolean = false) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            add(R.id.container, fragment, TAG)
            commitTransaction(this, addToBackStack)
        }
    }

    fun replaceFragment(fragment: Fragment, TAG: String?, addToBackStack: Boolean = false) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.container, fragment, tag)
            commitTransaction(this, addToBackStack)
        }

    }

    fun replaceChildFragment(
        parenFragment: Fragment = this,
        containerViewId: Int,
        fragment: Fragment,
        TAG: String?,
        addToBackStack: Boolean = false
    ) {
        val transaction = parenFragment.childFragmentManager.beginTransaction().apply {
            replace(containerViewId, fragment, TAG)
        }
        commitTransaction(transaction, addToBackStack)
    }

    fun addChildFragment(
        parenFragment: Fragment = this,
        containerViewId: Int,
        fragment: Fragment,
        TAG: String?,
        addToBackStack: Boolean = false
    ) {
        val transaction = parenFragment.childFragmentManager.beginTransaction().apply {
            add(containerViewId, fragment, TAG)
        }
        commitTransaction(transaction, addToBackStack)
    }

    private fun commitTransaction(
        transaction: FragmentTransaction,
        addToBackStack: Boolean = false
    ) {
        if (addToBackStack) transaction.addToBackStack(null)
        transaction.commit()
    }

}