package com.hinalin.home_portal_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hinalin.home_portal_mobile.ui.theme.HomeportalmobileTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.foundation.lazy.LazyColumn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeportalmobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MonitoringScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MonitoringScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { CameraSelectionChips() }
        item { GeckoImage() }
        item { RemoteController() }
        item { TemperatureAndHumidityInfo() }
        item { ControlCards() }
    }
}

@Composable
fun TemperatureAndHumidityInfo() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Thermostat,
                    contentDescription = "Temperature",
                    modifier = Modifier.size(24.dp)
                )
                Text("30.5°C", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.WaterDrop,
                    contentDescription = "Humidity",
                    modifier = Modifier.size(24.dp)
                )
                Text("56%", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CameraSelectionChips() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        FilterChip(
            selected = true,
            onClick = { /* Handle click */ },
            label = { Text("Front Camera") },
            modifier = Modifier.weight(1f)
        )
        FilterChip(
            selected = false,
            onClick = { /* Handle click */ },
            label = { Text("Rear Camera") },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun GeckoImage() {
    Image(
        painter = painterResource(id = R.drawable.gecko), // Replace with your image resource
        contentDescription = "Gecko",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4 / 3f)
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ControlCards() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard(
            onClick = { /* Handle click */ },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.daily_record), // Replace with your image resource
                    contentDescription = "Daily Record",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4 / 3f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Text("Daily record", fontWeight = FontWeight.Medium)
            }
        }
        ElevatedCard(
            onClick = { /* Handle click */ },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.personalize), // Replace with your image resource
                    contentDescription = "Personalize",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4 / 3f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Text("Personalize", fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CameraControlUIPreview() {
    MaterialTheme {
        MonitoringScreen()
    }
}

@Composable
fun RemoteController() {
    val backgroundColor = MaterialTheme.colorScheme.primaryContainer
    val buttonColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier
            .size(160.dp)
            .background(backgroundColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 16.dp)) {
            TriangleButton(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter),
                color = buttonColor
            ) { /* Handle Up Press */ }
        }
        Box(modifier = Modifier
            .align(Alignment.CenterStart)
            .padding(start = 16.dp)) {
            TriangleButton(
                Modifier
                    .size(30.dp)
                    .rotate(270f)
                    .align(Alignment.CenterStart),
                color = buttonColor
            ) { /* Handle Left Press */ }
        }
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .padding(end = 16.dp)) {
            TriangleButton(
                Modifier
                    .size(30.dp)
                    .rotate(90f)
                    .align(Alignment.CenterEnd),
                color = buttonColor
            ) { /* Handle Right Press */ }
        }
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp)) {
            TriangleButton(
                Modifier
                    .size(30.dp)
                    .rotate(180f)
                    .align(Alignment.BottomCenter),
                color = buttonColor
            ) { /* Handle Down Press */ }
        }
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(buttonColor, CircleShape)
                .clickable { /* Handle Center Press */ }
        )
    }
}

@Composable
fun TriangleButton(modifier: Modifier = Modifier, color: Color, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(TriangleShape)
            .background(color)
            .clickable { onClick() }
    )
}

val TriangleShape = GenericShape { size, _ ->
    val heightFactor = 0.5f
    moveTo(size.width / 2, 0f)
    lineTo(size.width, size.height * heightFactor)
    lineTo(0f, size.height * heightFactor)
    close()
}


@Preview(showBackground = true)
@Composable
fun SimpleRemoteControllerPreview() {
    MaterialTheme {
        RemoteController()
    }
}
