package com.disebud.week3apiapp.model

import com.google.gson.annotations.SerializedName

data class ResponseDataCorona(

	@field:SerializedName("missing_data")
	val missingData: Double? = null,

	@field:SerializedName("tanpa_provinsi")
	val tanpaProvinsi: Int? = null,

	@field:SerializedName("current_data")
	val currentData: Double? = null,

	@field:SerializedName("list_data")
	val listData: List<ListDataItem?>? = null,

	@field:SerializedName("last_date")
	val lastDate: String? = null
)

data class Lokasi(

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)

data class Penambahan(

	@field:SerializedName("meninggal")
	val meninggal: Int? = null,

	@field:SerializedName("positif")
	val positif: Int? = null,

	@field:SerializedName("sembuh")
	val sembuh: Int? = null
)

data class KelompokUmurItem(

	@field:SerializedName("usia")
	val usia: Usia? = null,

	@field:SerializedName("doc_count")
	val docCount: Int? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JenisKelaminItem(

	@field:SerializedName("doc_count")
	val docCount: Int? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class ListDataItem(

	@field:SerializedName("penambahan")
	val penambahan: Penambahan? = null,

	@field:SerializedName("doc_count")
	val docCount: Double? = null,

	@field:SerializedName("lokasi")
	val lokasi: Lokasi? = null,

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: Int? = null,

	@field:SerializedName("kelompok_umur")
	val kelompokUmur: List<KelompokUmurItem?>? = null,

	@field:SerializedName("jumlah_kasus")
	val jumlahKasus: Int? = null,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: Int? = null,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: List<JenisKelaminItem?>? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: Int? = null
)

data class Usia(

	@field:SerializedName("value")
	val value: Double? = null
)
