package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ResourceTypePicker(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    image: String,
    label: String
) {
    Card(
        elevation = 20.dp,
        modifier = modifier.size(170.dp).padding(5.dp),
        onClick = onClick,
    ) {
        Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.fillMaxHeight(0.70f)
                    .padding(bottom = 5.dp),
                painter = painterResource(image),
                contentDescription = label
            )

            Text(
                modifier = Modifier.padding(bottom = 3.dp),
                text = label,
                maxLines = 3,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        }
    }
}