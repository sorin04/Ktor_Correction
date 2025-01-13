package com.moser.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id_user: Int,
    val role: String,
    val username: String,
    val password: String?=null
)

