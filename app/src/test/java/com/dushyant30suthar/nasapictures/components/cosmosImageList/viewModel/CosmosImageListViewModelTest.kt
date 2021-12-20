package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.dushyant30suthar.nasapictures.base.liveData.Outcome
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.CosmosImageListErrorMapper
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.CosmosImageListRVItemsMapper
import com.dushyant30suthar.nasapictures.cosmosImageEntity
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases.GetCosmosImageListUseCase
import com.dushyant30suthar.nasapictures.mock
import com.dushyant30suthar.nasapictures.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class CosmosImageListViewModelTest {


    /*
    * Fields required to instantiate ViewModel.*/
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()


    @Mock
    lateinit var getCosmosImageListUseCase: GetCosmosImageListUseCase

    @Mock
    lateinit var mapper: CosmosImageListRVItemsMapper

    @Mock
    lateinit var errorMapper: CosmosImageListErrorMapper


    val recyclerViewItemsObserver = mock<Observer<in Outcome<List<RecyclerViewItem>>>>()

    /*
    * ViewModel Instance. */
    val viewModel by lazy {
        CosmosImageListViewModel(
            getCosmosImageListUseCase,
            mapper,
            errorMapper
        )
    }

    @Before
    fun initTest() {
        MockitoAnnotations.openMocks(this)
        reset(getCosmosImageListUseCase, recyclerViewItemsObserver)
    }


    @Test
    fun testLiveDataBeingSetUponResponse() {


        val response = listOf(cosmosImageEntity())


        whenever(getCosmosImageListUseCase.execute(Unit))
            .thenReturn(Single.just(response))

        viewModel.cosmosImageListRVLiveData.observeForever(recyclerViewItemsObserver)
        viewModel.getCosmosImageList()

        verify(getCosmosImageListUseCase).execute(Unit)


        val argumentCaptor = ArgumentCaptor.forClass(Outcome::class.java)


        argumentCaptor.run {
            verify(
                recyclerViewItemsObserver,
                times(1)
            ).onChanged(capture() as Outcome<List<RecyclerViewItem>>?)
        }
    }


}
