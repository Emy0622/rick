package br.senai.sp.jandira.rickandmorty.screens

//digitar com para criar
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rickandmorty.model.Results
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Preview
@Composable
fun ListAllCharacthers (modifier: Modifier = Modifier) {
    var charactersList by remember{
        mutableStateOf(listOf<Character>())
    }

    //efetuar chamada para API
    val charactersCall = RetrofitFactory()
        .getCharacterService()
        .getAllCharacters()

    charactersCall.enqueue(
        object : Callback<Results> {

            override fun onResponse(p0: Call<Results>, response: Response<Results>) {
                charactersList = response.body()!!.results

            }

            override fun onFailure(p0: Call<Results>, p1: Throwable) {}
            }

    )


    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFF71C9C6)

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                .padding(bottom = 32.dp),
                text = "Rick and Morty",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            LazyColumn (modifier = Modifier
                .fillMaxHeight()){
                items(charactersList)
                {
                    CharacterCard(it)
                }
            }
            {
                items(charactesList){
                    CharacterCard(it)
                }
            }

        }
    }
}

@Composable
fun CharacterCard(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card( modifier = Modifier
        .padding(bottom = 4.dp)
        .fillMaxWidth()
        .height(100.dp)
        .clickable {
            Toast
                .makeText(
                    context,
                    "Personagem: ${character.id}",
                    Toast.LENGTH_SHORT
                )
                .show()
        },
        colors = CardDefaults
        .cardColors(
            containerColor = Color(0x553B8991)
        )
    ) {

        Row{
            Card (
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
            ){
            }
        }
            AsyncImage(model = character.image,
                contentDescription = "")
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ) {

                Text(text = character.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                    )
                Text(text = "character.species,
                    color = Color.White
                )

            }
        }
}
//--
@Preview
@Composable
private fun ListAllcharactersPreview() {
    ListAllCharacthers()
}