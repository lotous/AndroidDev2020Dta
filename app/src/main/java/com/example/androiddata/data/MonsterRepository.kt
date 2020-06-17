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
package com.example.androiddata.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.LOG_TAG
import com.example.androiddata.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONTokener


/**
 * Class MonsterRepository
 *
 * @author Elbert Tous <contact@lotous.com.co>
 * @version 1.0
 * @since 2020-06-15 22:25
 */
class MonsterRepository(private val context: Context) {

    val monsterData = MutableLiveData<List<Monster>>()

    init {
       monsterData.value = getMonsterData()
       Log.i(LOG_TAG, "Monster Data Is Available:")
    }

    private fun getMonsterData() : List<Monster> {
        val json = FileHelper.getTextFromAssets(context, "monster_data.json")
        val jsonObject = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, Monster::class.java)
        val adapter: JsonAdapter<List<Monster>> = jsonObject.adapter(listType)
        return adapter.fromJson(json)?:emptyList()
    }


}