package com.dushyant30suthar.nasapictures.base.viewModel

import android.widget.ImageView
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.fragment.app.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dushyant30suthar.nasapictures.R

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

fun ImageView.loadImage(
    url: String?,
    @DrawableRes placeholder: Int? = R.drawable.loading,
    @DrawableRes errorDrawable: Int? = R.drawable.error
) {
    Glide.with(this)
        .load(url)
        .also { glide ->
            val requestOptions = RequestOptions()
            placeholder?.also { drawable ->
                requestOptions.placeholder(drawable)
            }
            errorDrawable?.let { errorDrawable ->
                requestOptions.error(errorDrawable)
            }
            glide.apply(requestOptions)

        }.into(this)
}