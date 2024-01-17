package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                CheckoutPage()
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CheckoutPage() {
        val cardBackgroundColor = Color(0xFFeff3fb)
        val mintColor = Color(0xFF52B69A)
        val orangeTextColor = Color(0xFFE2851C)
        val darkGreyTextColor = Color(0xFF71828A)
        val darkTextColor = Color(0xFF172B4D)
        val whiteColor = Color(0xFFFFFFFF)
        val strokeColor = Color(0xFFD0DBE5)
        val refField by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .width(414.dp)
                        .height(52.dp)
                        .background(color = Color(0xFFFFFFFF))
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        modifier = Modifier
                            .clickable {
                                // Implement back action here
                            }
                    )

                    TopAppBar(
                        modifier = Modifier
                            .padding(end = 26.dp),
                        colors = topAppBarColors(
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                        title = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 15.sp,
                                maxLines = 1,
                                text = "চেক আউট",
                                fontWeight = FontWeight(700),
                                color = darkTextColor,
                            )
                        }

                    )
                }

            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(
                        color = cardBackgroundColor
                    )
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                CoverCard(darkTextColor, darkGreyTextColor, mintColor, orangeTextColor)

                ReferralCard(strokeColor, whiteColor, refField, darkGreyTextColor)

                TotalCostCard(darkGreyTextColor, mintColor, strokeColor, darkTextColor)

                ContinueButton(mintColor, whiteColor)

            }
        }
    }


    @Composable
    private fun CoverCard(
        darkTextColor: Color,
        darkGreyTextColor: Color,
        mintColor: Color,
        orangeTextColor: Color
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),

            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                .width(382.dp)
                .height(350.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover),
                    contentDescription = "Cover Card"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        text = "বান্ডেল প্যাকেজ",
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight(700),
                        color = darkTextColor,
                    )
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                    )
                    Row {
                        Text(
                            text = "৳৪৮০০",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = darkGreyTextColor,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                        )
                        Spacer(
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text(
                            text = "৳২৯৭৫ (৩৮% ছাড়ে)",
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(700),
                            color = mintColor,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = "১৪-২৬ আগস্ট ৪৮% ছাড়ে মাত্র ৳২৫০০",
                        color = orangeTextColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight(500),
                    )
                }
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun ReferralCard(
        strokeColor: Color,
        whiteColor: Color,
        refField: String,
        darkGreyTextColor: Color
    ) {
        var refField1 = refField
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .width(382.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.reficon),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = strokeColor,
                        unfocusedBorderColor = strokeColor,
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, end = 10.dp)
                        .background(color = whiteColor),
                    value = refField1,
                    onValueChange = { refField1 = it },
                    label = {
                        Text(
                            "Have a referral code?",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = darkGreyTextColor,
                        )
                    }
                )

            }

        }
    }

    @Composable
    private fun TotalCostCard(
        darkGreyTextColor: Color,
        mintColor: Color,
        strokeColor: Color,
        darkTextColor: Color
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .width(382.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "সাবস্ক্রিপশন ফি",
                        color = darkGreyTextColor,
                        lineHeight = 19.sp,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(700),
                    )
                    Text(
                        text = "৳ ৪৮০০",
                        color = darkGreyTextColor,
                        lineHeight = 19.sp,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(700),
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "অফার ডিসকাউন্ট (৪৮%)",
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight(700),
                        color = mintColor,
                    )
                    Text(
                        text = "৳ ২৩০০",
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight(700),
                        color = mintColor,
                    )


                }

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(350.dp)
                        .height(1.dp)
                        .background(color = strokeColor),
                ) {

                }

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "টোটাল",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = darkTextColor,
                    )
                    Text(
                        text = "৳২৫০০",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = darkTextColor,
                    )
                }
            }

        }
    }

    @Composable
    private fun ContinueButton(
        mintColor: Color,
        whiteColor: Color
    ) {
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = mintColor),
            modifier = Modifier
                .width(382.dp)
                .height(56.dp),
            onClick = { /*TODO*/ }
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "এগিয়ে যাও",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = whiteColor,
                    textAlign = TextAlign.Center,
                )
            }

        }
    }

}