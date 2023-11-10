package com.dam.codelab_superheroes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.codelab_superheroes.model.Hero
import com.dam.codelab_superheroes.model.HeroesRepository.heroes
import com.dam.codelab_superheroes.ui.theme.SuperheroesTheme
import com.dam.codelab_superheroes.ui.theme.hero_card_color_1
import com.dam.codelab_superheroes.ui.theme.hero_card_color_2
import com.dam.codelab_superheroes.ui.theme.hero_card_color_3
import com.dam.codelab_superheroes.ui.theme.hero_card_color_4
import com.dam.codelab_superheroes.ui.theme.hero_card_color_5
import com.dam.codelab_superheroes.ui.theme.hero_card_color_6
import com.dam.codelab_superheroes.ui.theme.hero_name_color_1
import com.dam.codelab_superheroes.ui.theme.hero_name_color_2
import com.dam.codelab_superheroes.ui.theme.hero_name_color_3
import com.dam.codelab_superheroes.ui.theme.hero_name_color_4
import com.dam.codelab_superheroes.ui.theme.hero_name_color_5
import com.dam.codelab_superheroes.ui.theme.hero_name_color_6


@Preview(showBackground = false, showSystemUi = false)
@Composable
fun PreviewHeroItem() {
    SuperheroesTheme {
        HeroList()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroList() {
    var heroId by remember { mutableStateOf(0) }
    val callbackHeroId: (Int) -> Unit = { id ->
        heroId = id
    }
    val callbackToMain: () -> Unit = {
        heroId = 0
    }


    Scaffold(topBar = { HeroTopBar() }) { it ->
        if (heroId == 0) {
            LazyColumn(contentPadding = it) {
                items(heroes) {
                    HeroItem(
                        it,
                        Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        callbackHeroId
                    )
                }
            }
        } else {
            HeroStats(heroId, Modifier.padding(horizontal = 16.dp), callbackToMain)
        }

    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier,
    callbackHeroId: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }


    Card(
        modifier = modifier.clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .height(72.dp)

            ) {
                Column(
                    modifier = Modifier.weight(2f)
                ) {
                    Text(
                        text = stringResource(id = hero.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(id = hero.descriptionRes),
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 20.sp
                    )

                }
                Spacer(modifier = Modifier.padding(16.dp))
                Box() {
                    Image(
                        painter = painterResource(id = hero.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(RoundedCornerShape(8.dp)),
                    )
                }
            }
            if (expanded) {
                AdditionalInfo(hero, Modifier.padding(16.dp), callbackHeroId = callbackHeroId)
            }
        }
    }
}


@Composable
fun HeroStats(heroId: Int, modifier: Modifier, callbackToMain: () -> Unit) {
    var statsPictureRes = 0
    var heroPictureRes = 0
    var heroNameRes = 0
    var colorCard = Color(1)
    var colorName = Color(1)
    when (heroId) {
        1 -> {
            statsPictureRes = R.drawable.stats_1
            heroPictureRes = R.drawable.android_superhero1
            heroNameRes = R.string.hero1
            colorCard = hero_card_color_1
            colorName = hero_name_color_1
        }

        2 -> {
            statsPictureRes = R.drawable.stats_2
            heroPictureRes = R.drawable.android_superhero2
            heroNameRes = R.string.hero2
            colorCard = hero_card_color_2

            colorName = hero_name_color_2
        }

        3 -> {
            statsPictureRes = R.drawable.stats_3
            heroPictureRes = R.drawable.android_superhero3
            heroNameRes = R.string.hero3
            colorCard = hero_card_color_3
            colorName = hero_name_color_3
        }

        4 -> {
            statsPictureRes = R.drawable.stats_4
            heroPictureRes = R.drawable.android_superhero4
            heroNameRes = R.string.hero4
            colorCard = hero_card_color_4
            colorName = hero_name_color_4
        }

        5 -> {
            statsPictureRes = R.drawable.stats_5
            heroPictureRes = R.drawable.android_superhero5
            heroNameRes = R.string.hero5
            colorCard = hero_card_color_5
            colorName = hero_name_color_5
        }

        6 -> {
            statsPictureRes = R.drawable.stats_6
            heroPictureRes = R.drawable.android_superhero6
            heroNameRes = R.string.hero6
            colorCard = hero_card_color_6
            colorName = hero_name_color_6
        }
    }
    Card(
        modifier = modifier.padding(top = 150.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorCard,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = statsPictureRes),
                contentDescription = null,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(start = 8.dp),
                    painter = painterResource(id = heroPictureRes),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = heroNameRes),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    color = colorName
                )
                Button(onClick = callbackToMain, modifier = Modifier.padding(end = 8.dp)) {
                    Text(text = stringResource(id = R.string.back_to_main))
                }
            }
        }
    }
}


@Composable
fun AdditionalInfo(hero: Hero, modifier: Modifier = Modifier, callbackHeroId: (Int) -> Unit) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.power),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = stringResource(id = hero.powerRes))
        Spacer(modifier = Modifier.weight(1f))
        OutlinedButton(onClick = { callbackHeroId(hero.heroId) }) {
            Text(text = stringResource(id = R.string.see_stats))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = modifier
        )

    })
}




