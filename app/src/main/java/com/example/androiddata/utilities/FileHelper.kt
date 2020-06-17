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
package com.example.androiddata.utilities

import android.content.Context
import com.example.androiddata.data.Monster
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONTokener
import java.io.IOException

/**
 * Class FileHelper
 *
 * @author Elbert Tous <contact@lotous.com.co>
 * @version 1.0
 * @since 2020-06-15 18:53
 */
class FileHelper {
    companion object {
        fun getTextFromResource(context: Context?, resourceId: Int):String? {
            val dataString: String
            try {
                dataString = context!!.resources.openRawResource(resourceId).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return dataString
        }

        fun getTextFromAssets(context: Context?, fileName: String):String {
            val dataString: String
            try {
                dataString = context!!.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return "[]"
            }
            return dataString
        }



    }
}