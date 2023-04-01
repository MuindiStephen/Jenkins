package com.steve_md.socialsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.steve_md.socialsapp.model.Posts
import com.steve_md.socialsapp.ui.theme.SocialsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PostItem(posts: Posts) {
   Card(
       modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp)
           .height(150.dp),
       shape = RoundedCornerShape(10.dp),
       elevation = 6.dp
   ) {
       Surface {
           Row(
               modifier = Modifier
                   .padding(8.dp)
                   .fillMaxSize()
           ) {
               Image(painter = rememberImagePainter(data = posts.url,), contentDescription = posts.title,
               modifier = Modifier
                   .fillMaxHeight()
                   .weight(0.2f,true)
               )
           }
       }
   }
}

