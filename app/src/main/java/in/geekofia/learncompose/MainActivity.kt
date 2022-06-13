package `in`.geekofia.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import `in`.geekofia.learncompose.ui.theme.LearnComposeTheme
import `in`.geekofia.learncompose.ui.theme.Typography
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Greeting("Chandan")
                        CustomItem(weight = 1f, color = MaterialTheme.colors.secondary)
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CustomItem(weight = 1f, color = MaterialTheme.colors.error)
                            CustomItem(weight = 1f)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello 👋 $name",
        style = Typography.h1
    )
}

@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}
}

@Composable
fun RowScope.CustomItem(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .height(200.dp)
            .weight(weight),
        color = color
    ) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomItem(weight = 3f, color = MaterialTheme.colors.secondary)
            CustomItem(weight = 1f)
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomItem(weight = 3f, color = MaterialTheme.colors.secondary)
            CustomItem(weight = 1f)
        }
    }
}