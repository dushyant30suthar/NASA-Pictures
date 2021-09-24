package com.dushyant30suthar.cleanarchitecture.base.mapper

interface Mapper<in Src, out Des> {
    fun map(srcObject: Src): Des
}