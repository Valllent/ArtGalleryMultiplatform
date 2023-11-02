package com.valllent.shared.ui.pagination

class PagerActions<T>(
    private val pager: CustomPager<T>
) {

    fun onLastPageLoaded() {
        pager.onLoadingLastPage()
    }

}