package com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases

import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import org.mockito.Mockito
import org.mockito.Mockito.RETURNS_DEEP_STUBS
import org.mockito.stubbing.OngoingStubbing
import java.util.*
import kotlin.collections.ArrayList

const val LIMIT_COSMOS_IMAGE_LIST = 5

inline fun <reified T> mock() = Mockito.mock(T::class.java, RETURNS_DEEP_STUBS)

inline fun <T> whenever(methodCall: T): OngoingStubbing<T> =
    Mockito.`when`(methodCall)

fun limitCosmosImageListSizeArrayEmptyCosmosImageModel() =
    ArrayList<CosmosImageModel>(
        Collections.nCopies(
            LIMIT_COSMOS_IMAGE_LIST, cosmosImageModelFrom(
                cosmosImageEntity()
            )
        )
    )

fun cosmosImageEntity() =
    CosmosImageEntity(
        date = "2019-12-01",
        copyright = "ESA/HubbleNASA",
        mediaType = "image",
        hdUrl = "https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg",
        serviceVersion = "v1",
        explanation = "Why does this galaxy have a ring of bright blue stars?  Beautiful island universe Messier 94 lies a mere 15 million light-years distant in the northern constellation of the Hunting Dogs (Canes Venatici). A popular target for Earth-based astronomers, the face-on spiral galaxy is about 30,000 light-years across, with spiral arms sweeping through the outskirts of its broad disk. But this Hubble Space Telescope field of view spans about 7,000 light-years across M94's central region. The featured close-up highlights the galaxy's compact, bright nucleus, prominent inner dust lanes, and the remarkable bluish ring of young massive stars. The ring stars are all likely less than 10 million years old, indicating that M94 is a starburst galaxy that is experiencing an epoch of rapid star formation from inspiraling gas. The circular ripple of blue stars is likely a wave propagating outward, having been triggered by the gravity and rotation of a oval matter distributions. Because M94 is relatively nearby, astronomers can better explore details of its starburst ring.    Astrophysicists: Browse 2,000+ codes in the Astrophysics Source Code Library",
        title = "Starburst Galaxy M94 from Hubble",
        url = "https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg"
    )

fun cosmosImageModelFrom(cosmosImageEntity: CosmosImageEntity) =
    CosmosImageModel(
        imageUrl = cosmosImageEntity.url,
        imageTitle = cosmosImageEntity.title,
        imageDescription = cosmosImageEntity.explanation,
        date = cosmosImageEntity.date,
        viewType = R.layout.item_cosmos_image
    )