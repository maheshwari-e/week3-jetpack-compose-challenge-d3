package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class Item(val name:String, @DrawableRes val Image: Int)

val favorities = listOf<Pair<Item, Item>>(
    Pair(Item("Stress anxiety",R.drawable.pexels_jim),Item("Nature medications", R.drawable.pexels_nothing_ahead)),
    Pair(Item("Nightly wind down", R.drawable.pexels_jakub),Item("Self messages", R.drawable.pexels_scott_webb)),
    Pair(Item("Overwhelmed", R.drawable.pexels_ruvim), Item("Short mantras", R.drawable.pexels_mantras))
)

val alignbodies = listOf<Item>(
    Item("Inversions",R.drawable.pexels_chevanon),
    Item("Quick yoga", R.drawable.pexels_agung),
    Item("Stretching", R.drawable.pexels_cliff),
    Item("Tabata", R.drawable.pexels_elly),
    Item("HIIT", R.drawable.pexels_lazy),
    Item("Pre-natal yoga", R.drawable.pexels_freestocksorg)
)

val alignminds = listOf<Item>(
    Item("Mediate",R.drawable.pexels_elly_fairytale),
    Item( "With kids",R.drawable.pexels_valeria),
    Item( "Aromatherapy",R.drawable.pexels_karolina),
    Item( "On the go",R.drawable.pexels_suraphat),
    Item("With pets",R.drawable.pexels_cottonbro),
    Item( "High stress",R.drawable.pexels_nathan)
)