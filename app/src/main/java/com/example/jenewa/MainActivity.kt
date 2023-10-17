package com.example.jenewa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.jenewa.ui.theme.JenewaTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JenewaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.im1,
                        R.drawable.im2,
                        R.drawable.im3,
                        R.drawable.im4,
                        R.drawable.im5,
                        R.drawable.im6,
                        R.drawable.im7,
                        R.drawable.im8,
                        R.drawable.im9,
                        R.drawable.im10
                    )

                    val names = arrayOf(
                        "Kewirausahaan",
                        "Pengantar Kecerdasan Buatan",
                        "Pencitraan Komputer",
                        "Metode Penelitian",
                        "Mobile Computing",
                        "Animasi Komputer",
                        "Komputer Masyarakat",
                        "Bahasa Automata",
                        "Pemrograman Web",
                        "Dasar Pemrograman"
                    )

                    val skss = arrayOf(
                        3,3,3,2,3,3,2,3,3,3
                    )

                    MyApp(imageId,names,skss)
                }
            }
        }
    }
}

@Composable
fun MyApp(imageId: Array<Int>, names: Array<String>, skss: Array<Int>, modifier: Modifier = Modifier) {
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        val itemCount = imageId.size
        items(itemCount){ item->
            ColumnItem(
                itemIndex = item,
                painter = imageId,
                title = names,
                skss = skss,
                modifier
            )
        }
    }
}

@Composable
fun ColumnItem(itemIndex: Int, painter: Array<Int>, title: Array<String>, skss: Array<Int>, modifier: Modifier) {
     Card(
         modifier
             .padding(10.dp)
             .wrapContentSize(),
         colors = CardDefaults.cardColors(
             containerColor = Color.White
         ),
         elevation = CardDefaults.cardElevation(10.dp)
     ){
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ){
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Text(text = "${skss[itemIndex].toString()} sks",
                    fontSize = 18.sp)
            }
        }
     }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}