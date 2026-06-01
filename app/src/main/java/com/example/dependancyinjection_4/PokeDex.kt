package com.example.dependancyinjection_4

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeDex(viewModel: UsersViewModel = hiltViewModel(), navController: NavController) {

    val character = viewModel.character.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            Icons.Default.List, contentDescription = "",
                            tint = Color(0xFFA52A2A),
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(Modifier.width(12.dp))

                        Text(
                            "PokeDex",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFA52A2A)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                Icons.Default.Search, contentDescription = "",
                                tint = Color.Black,
                                modifier = Modifier
                                    .padding(end = 12.dp)
                                    .size(30.dp),
                            )
                        }
                    }
                }
            )
        }, bottomBar = {
            BottomAppBar() {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40.dp))
                            .background(color = Color(0xFFA52A2A))
                            .padding(horizontal = 20.dp, vertical = 12.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.MailOutline, contentDescription = "",
                            tint = Color.White
                        )

                        Text(
                            "Pokedex",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.AccountBox, contentDescription = "",
                            tint = Color.Gray
                        )

                        Text(
                            "Teams",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Person, contentDescription = "",
                            tint = Color.Gray
                        )

                        Text(
                            "Profile",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = "", onValueChange = {},

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray, RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp)),

                leadingIcon = {
                    Icon(
                        Icons.Default.Search, contentDescription = "",
                        tint = Color.Gray
                    )
                },
                placeholder = {

                    Text(
                        "Search Pokemon...",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                },

                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
            LazyColumn(modifier = Modifier) {

                items(character.itemCount) { index ->
                    character[index]?.let {
                        ProfileList(character = it, navController)
                    }
                }

            }
        }
    }
}

    @Composable
    fun ProfileList(character: Result, navController: NavController) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable{
                    navController.navigate("Screen2/${character.name}")
                },
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        "${character.name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        "${character.url}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.KeyboardArrowRight, contentDescription = "",
                        tint = Color(0xFFA52A2A),
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD8A7A7))
                            .padding(4.dp),
                    )
                }
            }
        }
    }
