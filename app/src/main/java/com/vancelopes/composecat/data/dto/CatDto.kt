package com.vancelopes.composecat.data.dto

import com.google.gson.annotations.SerializedName
import com.vancelopes.composecat.domain.model.Breed
import com.vancelopes.composecat.domain.model.Cat
import com.vancelopes.composecat.domain.model.CatImage
import com.vancelopes.composecat.domain.model.Category
import com.vancelopes.composecat.domain.model.Weight

data class CatDto (
    val breeds: List<BreedDto>?,
    val id: String,
    val url: String,
    val width: Long,
    val height: Long,
    val categories: List<CategoryDto>?,
) {
    fun toCat(): Cat {
        return Cat(
            id = id,
            breeds = breeds?.map { it.toBreed() },
            image = CatImage(url, width, height),
            categories = categories?.map { it.toCategory() }
        )
    }
}

data class BreedDto(
    val weight: WeightDto,
    val id: String,
    val name: String,
    @SerializedName("cfa_url")
    val cfaUrl: String,
    @SerializedName("vetstreet_url")
    val vetstreetUrl: String,
    @SerializedName("vcahospitals_url")
    val vcahospitalsUrl: String,
    val temperament: String,
    val origin: String,
    @SerializedName("country_codes")
    val countryCodes: String,
    @SerializedName("country_code")
    val countryCode: String,
    val description: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    val indoor: Long,
    val lap: Long?,
    @SerializedName("alt_names")
    val altNames: String,
    val adaptability: Long,
    @SerializedName("affection_level")
    val affectionLevel: Long,
    @SerializedName("child_friendly")
    val childFriendly: Long,
    @SerializedName("dog_friendly")
    val dogFriendly: Long,
    @SerializedName("energy_level")
    val energyLevel: Long,
    val grooming: Long,
    @SerializedName("health_issues")
    val healthIssues: Long,
    val intelligence: Long,
    @SerializedName("shedding_level")
    val sheddingLevel: Long,
    @SerializedName("social_needs")
    val socialNeeds: Long,
    @SerializedName("stranger_friendly")
    val strangerFriendly: Long,
    val vocalisation: Long,
    val experimental: Long,
    val hairless: Long,
    val natural: Long,
    val rare: Long,
    val rex: Long,
    @SerializedName("suppressed_tail")
    val suppressedTail: Long,
    @SerializedName("short_legs")
    val shortLegs: Long,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String,
    val hypoallergenic: Long,
    @SerializedName("reference_image_id")
    val referenceImageId: String,
) {
    fun toBreed(): Breed {
        return Breed(
            weight = weight.toWeight(),
            wikipediaUrl = wikipediaUrl,
            id = id,
            name = name,
            temperament = temperament,
            altNames = altNames,
            lifeSpan = lifeSpan,
            description = description,
            origin = origin,
            indoor = indoor
        )
    }
}

data class WeightDto(
    val imperial: String,
    val metric: String,
) {
    fun toWeight(): Weight {
        return Weight(metric = metric)
    }
}

data class CategoryDto(
    val id: Long,
    val name: String,
) {
    fun toCategory(): Category {
        return Category(
            id = id,
            name = name
        )
    }
}