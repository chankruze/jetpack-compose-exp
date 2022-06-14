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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        CustomText("Chandan")
                        CustomText3()
                    }
                }
            }
        }
    }

    @Composable
    fun CustomText(name: String) {
        Text(
            text = "Hello 👋 $name",
            modifier = Modifier
                .background(MaterialTheme.colors.primary) // order matters
                .padding(16.dp),
            color = Color.White,
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun CustomText2() {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h1.fontSize
                    )
                ) {
                    append("H")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.Yellow,
                    )
                ) {
                    append("E")
                }

                append("L")
                append("L")
                append("O")
            }
        )
    }

    @Composable
    fun CustomText3() {
        SelectionContainer {
            Column {
                Text(
                    text = "Hello!".repeat(50),
                    modifier = Modifier.padding(16.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                )

                DisableSelection {
                    Text(
                        text = "Hello!".repeat(50),
                        modifier = Modifier.padding(16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Text(
                    text = "Hello!".repeat(50),
                    modifier = Modifier.padding(16.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        LearnComposeTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                CustomText("Chandan")
                CustomText3()
            }
        }
    }
}