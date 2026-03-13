package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // делает контент под системные панели

        setContent {
            VisitCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize() // контейнер на весь экран
                ) {
                    GreetingText( // основной контент визитки
                        name = "Дубинин Родион Саныч",
                        title = "Крутой чмоня"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, title: String, modifier: Modifier = Modifier) {

    // Основная вертикальная колонка
    Column(
        verticalArrangement = Arrangement.Top, // элементы идут сверху вниз
        horizontalAlignment = Alignment.CenterHorizontally, // центрируем по горизонтали
        modifier = Modifier
            .fillMaxSize() // колонка занимает весь экран
            .padding(top = 90.dp) // отступ сверху
    ) {

        // Фото пользователя
        Photo(
            modifier = Modifier
                .size(210.dp) // размер фото
                .clip(MaterialTheme.shapes.medium) // скругление углов
        )

        // Имя
        Text(
            text = name,
            fontSize = 28.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF355E3B),
            modifier = Modifier.padding(top = 90.dp) // отступ от фото
        )

        // Должность
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF355E3B),
            modifier = Modifier.padding(top = 4.dp)
        )

        // Блок контактов
        Column(
            modifier = Modifier.padding(top = 100.dp), // отступ от должности
            horizontalAlignment = Alignment.Start // выравнивание влево
        ) {
            ContactRow("📞", "+7(987)496-35-49", color = Color(0xFF355E3B))
            ContactRow("🔗", "@Radium_Mr226", color = Color(0xFF355E3B))
            ContactRow("✉️", "wryotuwork@gmail.com", color = Color(0xFF355E3B))
        }
    }
}

@Composable
fun ContactRow(icon: String, text: String, color: Color = Color.Black) {

    // Горизонтальная строка: иконка + текст
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp) // расстояние между строками
    ) {
        Text(text = icon, fontSize = 20.sp, color = color) // иконка
        Text(
            text = text,
            fontSize = 18.sp,
            color = color,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 8.dp) // отступ от иконки
        )
    }
}

@Composable
private fun BackgroundImage(name: String, title: String, modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.backphoto) // загружаем фон

    // Box позволяет накладывать элементы друг на друга
    Box(modifier.fillMaxSize()) { // растягиваем фон на весь экран

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // обрезает красиво под экран
            modifier = Modifier.fillMaxSize() // растягивает картинку
        )

        // Контент поверх фона
        GreetingText(
            name = name,
            title = title,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
private fun Photo(modifier: Modifier = Modifier) {

    // Фото пользователя
    Image(
        painter = painterResource(id = R.drawable.photo),
        contentDescription = "Аватар пользователя",
        contentScale = ContentScale.Crop, // обрезает фото под рамку
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun VisitPreview() {

    // Превью визитки в Android Studio
    VisitCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundImage(
                name = "Дубинин Родион Саныч",
                title = "Крутой чмоня"
            )
        }
    }
}
