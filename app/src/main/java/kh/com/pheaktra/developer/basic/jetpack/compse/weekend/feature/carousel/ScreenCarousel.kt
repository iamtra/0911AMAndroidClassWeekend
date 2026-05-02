package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.carousel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCarousel() {
    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        val contentDescription: String
    )
    val carouselItems = remember {
        listOf(
            CarouselItem(0, R.drawable.img_1, "cupcake"),
            CarouselItem(1, R.drawable.img_2, "donut"),
            CarouselItem(2, R.drawable.img_3, "eclair"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
            CarouselItem(3, R.drawable.img_4, "froyo"),
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            println("You click Navigation Icon")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Screen Carousel",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W900,
                        fontStyle = FontStyle.Normal
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_200),
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            HorizontalMultiBrowseCarousel(
                state = rememberCarouselState{
                    carouselItems.size
                },
                preferredItemWidth = 450.dp,
                itemSpacing = 12.dp
            ) { index ->
                val item = carouselItems[index]
                Image(
                    modifier = Modifier.clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                        .height(512.dp),
                    painter = painterResource(item.imageResId),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCarouselPreview() {
    ScreenCarousel()
}
