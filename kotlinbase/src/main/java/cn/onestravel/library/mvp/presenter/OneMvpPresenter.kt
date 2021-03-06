package cn.onestravel.library.mvp.presenter

import android.os.Bundle
import cn.onestravel.library.mvp.view.OneMvpView

/**
 * @name  OneMvpPresenterImpl
 * @description 所有界面presenter的接口类
 * @createTime 2018/12/12 16:27
 * @author onestravel
 * @version 1.0.0
 */

interface OneMvpPresenter<in V : OneMvpView> {
    fun onMvpAttachView(view: V, savedInstanceState: Bundle?)

    fun onMvpStart()

    fun onMvpResume()

    fun onMvpPause()

    fun onMvpStop()

    fun onMvpSaveInstanceState(savedInstanceState: Bundle?)

    fun onMvpDetachView(retainInstance: Boolean)

    fun onMvpDestroy()

    fun init()

}