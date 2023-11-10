package com.dam.codelab_superheroes.model

import com.dam.codelab_superheroes.R

object HeroesRepository {
    val heroes = listOf(
        Hero(
            heroId = 1,
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_superhero1,
            powerRes = R.string.super_strengh
        ),
        Hero(
            heroId =2,
            nameRes = R.string.hero2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.android_superhero2,
            powerRes = R.string.telekinesis
        ),
        Hero(
            heroId = 3,
            nameRes = R.string.hero3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.android_superhero3,
            powerRes = R.string.teleportation
        ),
        Hero(
            heroId = 4,
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.android_superhero4,
            powerRes = R.string.mind_reading
        ),
        Hero(
            heroId = 5,
            nameRes = R.string.hero5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.android_superhero5,
            powerRes = R.string.time_travel
        ),
        Hero(
            heroId = 6,
            nameRes = R.string.hero6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.android_superhero6,
            powerRes = R.string.invisibility
        ),
        Hero(
            heroId = 7,
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.android_superhero4,
            powerRes = R.string.mind_reading
        ),
        Hero(
            heroId = 5,
            nameRes = R.string.hero5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.android_superhero5,
            powerRes = R.string.time_travel
        ),
        Hero(
            heroId = 6,
            nameRes = R.string.hero6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.android_superhero6,
            powerRes = R.string.invisibility
        )
    )
}