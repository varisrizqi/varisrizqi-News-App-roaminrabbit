package com.example.news_app_roaminrabbit.data.dummy

import com.example.news_app_roaminrabbit.data.Util.DESC_FIVE
import com.example.news_app_roaminrabbit.data.Util.DESC_FOUR
import com.example.news_app_roaminrabbit.data.Util.DESC_ONE
import com.example.news_app_roaminrabbit.data.Util.DESC_SIX
import com.example.news_app_roaminrabbit.data.Util.DESC_THREE
import com.example.news_app_roaminrabbit.data.Util.DESC_TWO
import com.example.news_app_roaminrabbit.domain.model.NewsItem

object DummyNewsProvider {

    val initialNews = listOf(
        NewsItem(
            id = "1",
            title = "Telkomsel dan AWS Cetak 750 Talenta Disabilitas Mahir Cloud dan AI",
            description = DESC_ONE
        ),
        NewsItem(
            id = "2",
            title = "Hutan Amazon Menuju Iklim ‘Hipertropis’, Pertama dalam 10 Juta Tahun Terakhir",
            description = DESC_TWO
        ),
        NewsItem(
            id = "3",
            title = "Prabowo: Ada yang Teriak Bencana Sumatera Jadi Bencana Nasional, RI Mampu",
            description = DESC_THREE
        ),
        NewsItem(
            id = "4",
            title = "SEA Games: Rizki Juniansyah Rebut Emas & Pecahkan Rekor Dunia!",
            description = DESC_FOUR
        ),
        NewsItem(
            id = "5",
            title = "Foto: Aksi Timnas Voli Putri Raih Perunggu SEA Games 2025",
            description = DESC_FIVE
        ),
        NewsItem(
            id = "6",
            title = "Foto: Inter Milan Iris Tipis Genoa di Liga Italia",
            description = DESC_SIX
        )
    )
}