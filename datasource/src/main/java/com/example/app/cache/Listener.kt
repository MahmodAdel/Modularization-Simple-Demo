package com.example.app.cache

interface Listener<T> {

    fun onResponse(response : T)
}