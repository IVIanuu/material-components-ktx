/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.materialcomponentsktx.internal

import java.lang.reflect.Field
import kotlin.reflect.KClass

private val FIELD_CACHE = mutableMapOf<Class<*>, MutableMap<String, Field?>>()

fun KClass<*>.field(name: String) = java.field(name)

fun Class<*>.field(name: String) = FIELD_CACHE.getOrPut(this) { mutableMapOf() }
    .getOrPut(name) {
        try {
            getDeclaredField(name).apply { isAccessible = true }
        } catch (e: Exception) {
            null
        }
    }
    ?: throw IllegalArgumentException("${this} field not found $name")
