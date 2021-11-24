package com.dushyant30suthar.cleanarchitecture.base.viewModel

import androidx.activity.viewModels
import androidx.fragment.app.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(
    provider: ViewModelProvider.Factory
) = viewModels<VM> { provider }


inline fun <reified VM : ViewModel> Fragment.getViewModel(
    provider: ViewModelProvider.Factory
) = viewModels<VM> { provider }


inline fun <reified VM : ViewModel> Fragment.getActivityViewModel(
    provider: ViewModelProvider.Factory
) =
    activityViewModels<VM> { provider }

inline fun <reified VM : ViewModel> Fragment.getParentViewModel(
    provider: ViewModelProvider.Factory
) = createViewModelLazy(
    VM::class, { requireParentFragment().viewModelStore },
    { provider }
)