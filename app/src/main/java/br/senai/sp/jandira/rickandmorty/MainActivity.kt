//é aonde desenhamos a tela
package br.senai.sp.jandira.rickandmorty


// control, option, o = apaga imports que nn estamos usando
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.rickandmorty.screens.CharacterDetails
import br.senai.sp.jandira.rickandmorty.screens.ListAllCharacthers
import br.senai.sp.jandira.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
//CharacterDetails()
                ListAllCharacthers()
            }
        }
    }
}


