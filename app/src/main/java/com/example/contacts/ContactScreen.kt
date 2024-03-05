package com.example.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun ContactScreen(
//    modifier: Modifier = Modifier,
//    contacts: List<Contact>
){
    Column {
        AddContact()
    }
}


@Composable
fun ContactItem(
    modifier: Modifier = Modifier,
    contact: Contact
){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = contact.firstName + " " + contact.lastName,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = contact.phoneNumber,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "delete contact",
            tint = Color.Red,
            modifier = Modifier
                .size(33.dp)
                .align(Alignment.CenterVertically)
        )
    }

}

@Composable
fun AddContact(
    viewModel: ContactViewModel = viewModel(),
//    firstName: String = "",
//    lastName: String = "",
//    phoneNumber: String = "",
//    onInputChange: (ContactEvent) -> Unit,
//    modifier: Modifier = Modifier
){
//    var firstNameInput by remember {
//        mutableStateOf(firstName)
//    }
    val uiState by viewModel.state.collectAsState()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 40.dp
        ),
        modifier = Modifier.size(280.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)

        ) {
            //firstname
            OutlinedTextField(
                value = uiState.firstName,
                label = {
                    Text(
                        text = "First Name",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                onValueChange = { viewModel.onEvent(ContactEvent.SetFirstName(uiState.firstName)) },
                modifier = Modifier.fillMaxWidth()
            )
            //lastname
            OutlinedTextField(
                value = uiState.lastName,
                label = {
                    Text(
                        text = "Last Name",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                onValueChange = { viewModel.onEvent(ContactEvent.SetLastName(uiState.lastName))},
                modifier = Modifier.fillMaxWidth()
            )
            //phone number
            OutlinedTextField(
                value = uiState.phoneNumber,
                label = {
                    Text(
                        text = "Phone Number",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                onValueChange = {
                    viewModel.onEvent(ContactEvent.SetPhoneNumber(uiState.phoneNumber))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { viewModel.onEvent(ContactEvent.SaveContact) },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text= "Add to contacts")
                
            }
        }

    }

    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddContactPreview(){
    AddContact()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactItemPreview(){
    ContactItem(
        contact = Contact("Simon", "Tutu", "67679900")
    )
}