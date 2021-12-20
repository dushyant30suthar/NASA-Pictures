package com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers

import com.dushyant30suthar.nasapictures.cosmosImageEntity
import com.dushyant30suthar.nasapictures.cosmosImageModelListFromEntityList
import org.junit.Assert.assertEquals
import org.junit.Test

/*
* To test if we are able to map our entities to models*/
class CosmosImageListRVItemsMapperTest {

    private val mapper = CosmosImageListRVItemsMapper()

    @Test
    fun `should map cosmosImageEntity to cosmosImageModel correctly`() {

        val responseEntities = listOf(cosmosImageEntity())

        val expectedEntities = cosmosImageModelListFromEntityList(listOf(cosmosImageEntity()))

        val resultModels = mapper.map(responseEntities)

        assertEquals(expectedEntities, resultModels)

    }

}