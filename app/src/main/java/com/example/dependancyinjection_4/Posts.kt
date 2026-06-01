package com.example.dependancyinjection_4

data class Posts(
    val id : Int,
    val name : String,
    val height : Int,
    val weight : Int,
    val sprites : Sprites,
    val types : List<Types>,
    val stats : List<Stats>,
    val abilities : List<Abilities>
)

data class Sprites(
    val front_default : String
)

data class Types(
    val slot : Int,
    val type : Type
)

data class Type(
    val name : String
)

data class Stats(
    val base_stat : Int,
    val stat : Stat
)

data class Stat(
    val name: String
)

data class Abilities(
    val ability : Ability
)

data class Ability(
    val name : String
)


