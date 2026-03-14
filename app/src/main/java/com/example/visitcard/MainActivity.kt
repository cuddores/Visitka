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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VisitCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    MainInfo(
                        name = getString(R.string.student_name),
                        title = getString(R.string.student_discribe)
                    )
                }
            }
        }
    }
}

@Composable
fun AllObjects(name: String, title: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
    ) {
        Avatar(
            modifier = Modifier
                .size(210.dp)
                .clip(MaterialTheme.shapes.medium)
        )

        Text(
            text = name,
            fontSize = 28.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF355E3B),
            modifier = Modifier.padding(top = 90.dp)
        )

        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF355E3B),
            modifier = Modifier.padding(top = 4.dp)
        )

        Column(
            modifier = Modifier.padding(top = 100.dp),
            horizontalAlignment = Alignment.Start
        ) {
            ContactView(Icons.Default.Call, stringResource(R.string.phone_number), color = Color(0xFF355E3B))
            ContactView(Icons.Default.Send, stringResource(R.string.telegram), color = Color(0xFF355E3B))
            ContactView(Icons.Default.Email, stringResource(R.string.gmail_com), color = Color(0xFF355E3B))
        }
    }
}

@Composable
fun ContactView(iconRow: ImageVector, text: String, color: Color = Color.Black) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = iconRow,
            contentDescription = stringResource(R.string.contact_info),
            modifier = Modifier.size(20.dp),
            tint = color
        )
        Text(
            text = text,
            fontSize = 18.sp,
            color = color,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun MainInfo(name: String, title: String, modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.backphoto)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = Crop,
        )
        AllObjects(
            name = name,
            title = title,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
private fun Avatar(modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.photo),
        contentDescription = stringResource(R.string.avatar_description),
        contentScale = Crop,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun VisitPreview() {
    VisitCardTheme {
        MainInfo(
            name = stringResource(R.string.student_name),
            title = stringResource(R.string.student_discribe)
        )
    }
}
