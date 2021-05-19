package com.no.aka.baseprojectkotlin

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.no.aka.baseprojectkotlin.di.module.databaseModule
import com.no.aka.baseprojectkotlin.di.module.networkModule
import com.no.aka.baseprojectkotlin.di.module.repositoryModel
import com.no.aka.baseprojectkotlin.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(databaseModule)
            modules(networkModule)
            modules(repositoryModel)
            modules(viewModelModule)
        }
    }

}