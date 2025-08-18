package compose.about.me.design.system.component

import android.content.Context
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.request.CachePolicy

@Composable
fun ProjectImage(
    model: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
    placeholder: @Composable (() -> Unit)? = null
) {
    val painter = rememberAsyncImagePainter(
        model = model,
        imageLoader = CoilImageLoader.getInstance(LocalContext.current),
        contentScale = contentScale,
        filterQuality = filterQuality
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painter,
            contentDescription = null,
            contentScale = contentScale
        )

        if (placeholder != null && painter.state !is AsyncImagePainter.State.Success) {
            placeholder()
        }
    }
}

private class CoilImageLoader {

    companion object {

        @Volatile
        private var instance: ImageLoader? = null

        fun getInstance(context: Context): ImageLoader {
            return instance ?: synchronized(this) {
                instance ?: coilImageLoader(context).also { instance = it }
            }
        }
    }
}

private fun coilImageLoader(
    context: Context
) = ImageLoader.Builder(context)
    .components {
        if (Build.VERSION.SDK_INT >= 28) {
            add(ImageDecoderDecoder.Factory())
        } else {
            add(GifDecoder.Factory())
        }
        add(SvgDecoder.Factory())
    }
    .crossfade(true)
    .diskCachePolicy(CachePolicy.ENABLED)
    .memoryCachePolicy(CachePolicy.ENABLED)
    .networkCachePolicy(CachePolicy.ENABLED)
    .build()
