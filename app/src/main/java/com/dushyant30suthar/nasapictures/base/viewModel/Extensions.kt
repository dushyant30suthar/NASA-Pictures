package com.dushyant30suthar.nasapictures.base.viewModel

import androidx.activity.viewModels
import androidx.fragment.app.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
* Extension methods to getViewModels*/

inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(
    provider: ViewModelProvider.Factory
) = viewModels<VM> { provider }


/*
* Models to get from Fragment.
*
* It's own viewModel
* It's parent's viewModel
* Activity's viewModel to which it is attached to.*/
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