/*
 *  Copyright (C) 2020 Elbert Tous.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.example.androiddata.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiddata.data.MonsterRepository

/**
 * Class MainViewModelFactory
 *
 * @author Elbert Tous <contact@lotous.com.co>
 * @version 1.0
 * @since 2020-06-15 23:42
 */
class MainViewModelFactory (private val context: Context) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataRepo = MonsterRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}