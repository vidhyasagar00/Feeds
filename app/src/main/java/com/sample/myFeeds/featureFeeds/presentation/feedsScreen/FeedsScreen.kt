package com.sample.myFeeds.featureFeeds.presentation.feedsScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sample.myFeeds.R
import com.sample.myFeeds.core.presentation.theme.FeedsTheme
import kotlin.random.Random

@Composable
fun FeedsScreen(
    navController: NavHostController
) {
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) {
            FeedsItem()
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
fun FeedsItem() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
    ) {

        FeedsItemHeader(
            "https://i.pinimg.com/564x/74/c1/c2/74c1c271189d47b2d0076e7a52134c02.jpg",
            "vidhyasagar00"
        ) {}

        Post(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            postUrl = "https://i.pinimg.com/564x/74/c1/c2/74c1c271189d47b2d0076e7a52134c02.jpg"
        )

        PostActionBtnGroup {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            when (it) {
                PostActionEvent.LIKE -> Unit
                PostActionEvent.COMMENT -> Unit
                PostActionEvent.SHARE -> Unit
            }
        }

        LikesView(
            modifier = Modifier.padding(start = 10.dp)
        )

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "2 minutes ago.",
            style = typography.labelSmall
        )
    }
}

enum class PostActionEvent {
    LIKE,
    COMMENT,
    SHARE
}

@Composable
fun PostActionBtnGroup(
    onClick: (PostActionEvent) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(start = 10.dp)
                .size(35.dp)
                .clickable { onClick(PostActionEvent.LIKE) },
            imageVector = Icons.Rounded.FavoriteBorder,
            contentDescription = "",
            colorFilter = ColorFilter.tint(colorScheme.onBackground)
        )
        Image(
            modifier = Modifier
                .padding(start = 20.dp)
                .size(35.dp)
                .clickable { onClick(PostActionEvent.COMMENT) },
            imageVector = Icons.Rounded.MailOutline,
            contentDescription = "",
            colorFilter = ColorFilter.tint(colorScheme.onBackground)
        )
        Image(
            modifier = Modifier
                .padding(start = 20.dp)
                .size(35.dp)
                .rotate(-25.0f)
                .offset(0.dp, (-5).dp)
                .clickable { onClick(PostActionEvent.SHARE) },
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = "",
            colorFilter = ColorFilter.tint(colorScheme.onBackground)
        )
    }
}

@Composable
fun Post(
    modifier: Modifier,
    postUrl: String
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(postUrl)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.FillHeight,
        contentDescription = "post Image",
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorScheme.primaryContainer)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(55.dp)
                )
            }
        },
        error = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorScheme.errorContainer)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Unable to fetch the post"
                )
            }
        }
    )
}

@Composable
fun FeedsItemHeader(
    profileUrl: String,
    userName: String,
    moreClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(profileUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.ic_profile_placeholder)
        )

        Text(
            modifier = Modifier
                .padding(start = 15.dp)
                .weight(1F),
            text = userName,
            style = typography.titleSmall
        )

        Icon(
            modifier = Modifier
                .clickable { moreClick() }
                .padding(5.dp),
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "button more"
        )
    }
}

@Composable
fun LikesView(
    modifier: Modifier = Modifier,
    likes: List<Int> = listOf(100, 200, 300, 400, 500, 600, 700, 800),
    size: Int = 20
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = modifier) {
            likes.take(3)
                .forEachIndexed { index, id ->
                    Log.d("TAG", "LikesView: $index $id ${((size / 2) * index)}")
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = ((size / 2) * index).dp)
                            .size(size.dp)
                            .clip(CircleShape)
                            .background(
                                Color(
                                    Random.nextInt(255),
                                    Random.nextInt(255),
                                    Random.nextInt(255)
                                )
                            ),
                        model = "",
                        contentDescription = "",
                    )
                }
        }

        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = buildAnnotatedString {
                append("liked by ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("${likes.random()} ")
                }
                append("and ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("others")
                }
            }
        )
    }
}

@PreviewLightDark
@Composable
fun FeedsItemPreview() {
    FeedsTheme {
        FeedsItem()
    }
}

@PreviewLightDark
@Composable
fun FeedsScreenPreview() {
    FeedsScreen(navController = rememberNavController())
}