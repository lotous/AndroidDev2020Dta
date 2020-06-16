package com.example.androiddata.ui.main


import androidx.lifecycle.ViewModel
import com.example.androiddata.data.MonsterRepository

class MainViewModel(dataRepo: MonsterRepository) : ViewModel() {
     val monsterData = dataRepo.monsterData
}
