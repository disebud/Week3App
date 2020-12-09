package com.disebud.week3apiapp.model

import com.google.gson.annotations.SerializedName

data class ResponseDaerah(

	@field:SerializedName("provinsi")
	val provinsi: List<ProvinsiItem?>? = null
)

data class ProvinsiItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
