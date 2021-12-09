package com.dushyant30suthar.nasapictures.base.mapper

interface Mapper<in Src, out Des> {
    fun map(srcObject: Src): Des
}