package com.example.citydbcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.citydbcompose.ItemRowModel
import com.example.citydbcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 9.dp, horizontal = 20.dp)){
                itemsIndexed(listOf(
                    ItemRowModel("Германия","Дортмунд"),
                    ItemRowModel("Чехия","Прага"),
                    ItemRowModel("Беларусь","Минск"),
                    ItemRowModel("Мальта","Валлетта"),
                    ItemRowModel("Нидерланды","Амстердам"),
                    ItemRowModel("Польша","Варшава"),
                    ItemRowModel("Россия","Москва"),
                    ItemRowModel("Северная Македония","Скопье"),
                    ItemRowModel("Словакия","Братислава"),
                    ItemRowModel("Украина","Киев"),
                    ItemRowModel("Франция","Париж"),
                    ItemRowModel("Швейцария","Берн"),
                    ItemRowModel("Эстония","Таллин"),
                    ItemRowModel("Бахрейн","Манама"),
                    ItemRowModel("Вьетнам","Ханой"),
                    ItemRowModel("Иордания","Амман"),
                    ItemRowModel("Казахстан","Астана"),
                    ItemRowModel("Малайзия","Куала-Лумпур"),
                    ItemRowModel("Непал","Катманду"),
                    ItemRowModel("Оман","Маскат"),
                    ItemRowModel("Сингапур","Сингапур (город)")
                )) {_,item->
                    MyRow(item = item)
                }
            }

    }

@Composable
fun MyRow(item: ItemRowModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
            .background(Color.White))
    {
    Text(text = item.title, fontSize = 25.sp)
    Text(text = item.content,fontSize = 25.sp)
    }
}
