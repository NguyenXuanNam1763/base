package com.no.aka.baseprojectkotlin.view.ui.map

import com.google.android.gms.maps.model.LatLng
import com.no.aka.baseprojectkotlin.base.BaseViewModel
import com.no.aka.baseprojectkotlin.repository.MapRepository

class MapViewModel(private val mapRepository: MapRepository) : BaseViewModel() {

    fun calculatorDistance(startPoint: LatLng?, endPoint: LatLng) {
        startPoint ?: return
        mapRepository.calculationByDistance(startPoint, endPoint)
    }

}