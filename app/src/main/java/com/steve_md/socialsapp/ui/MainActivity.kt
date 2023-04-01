package com.steve_md.socialsapp.ui

import android.icu.number.Scale
import android.os.Bundle
import android.view.Gravity.FILL
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
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
               Image(painter = rememberImagePainter(data = posts.url,
                   builder = {
                       scale(coil.size.Scale.FILL)
                       transformations(CircleCropTransformation())

                   }), contentDescription = posts.title,
               modifier = Modifier
                   .fillMaxHeight()
                   .weight(0.2f, true)
               )

               Column(
                   verticalArrangement = Arrangement.Center,
                   modifier = Modifier
                       .fillMaxHeight()
                       .weight(0.8f)
                       .padding(4.dp)
               ) {
                   Text(
                       text = posts.title,
                       style = MaterialTheme.typography.subtitle1,
                       fontWeight = FontWeight.Bold
                   )
                   Spacer(modifier = Modifier.width(2.dp))
                   Text(
                       text = posts.albumId,
                       style = MaterialTheme.typography.caption,
                       modifier = Modifier
                           .background(Color.LightGray)
                           .padding(4.dp)
                   )
                   Spacer(modifier = Modifier.width(2.dp))
                   Text(
                       text = posts.id,
                       style = MaterialTheme.typography.body1,
                       maxLines = 2,
                       overflow = TextOverflow.Ellipsis
                   )

               }
           }
       }
   }
}


