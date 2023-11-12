package com.vancelopes.composecat.domain.model

data class Cat(
    val breeds: List<Breed>?,
    val id: String,
    val image: CatImage,
    val categories: List<Category>?,
)

data class CatImage(
    val url: String,
    val width: Long,
    val height: Long,
)

data class Breed(
    val weight: Weight,
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val description: String,
    val lifeSpan: String,
    val indoor: Long,
    val altNames: String,
    val wikipediaUrl: String,
)

data class Weight(
    val metric: String,
)

data class Category(
    val id: Long,
    val name: String,
)