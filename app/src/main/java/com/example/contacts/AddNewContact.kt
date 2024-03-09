package com.example.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddNew(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit
){
    AlertDialog(
        onDismissRequest = { onEvent(ContactEvent.HideDialog) },
        confirmButton = { onEvent(ContactEvent.ShowDialog)},
        title = {Text(text = "Add New Contact")},
        text = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)

            ) {
                //firstname
                OutlinedTextField(
                    value = state.firstName,
                    label = {
                        Text(
                            text = "First Name",
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    onValueChange = { onEvent(ContactEvent.SetFirstName(it)) },
                    modifier = Modifier.fillMaxWidth()
                )
                //lastname
                OutlinedTextField(
                    value = state.lastName,
                    label = {
                        Text(
                            text = "Last Name",
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    onValueChange = { onEvent(ContactEvent.SetLastName(it))},
                    modifier = Modifier.fillMaxWidth()
                )
                //phone number
                OutlinedTextField(
                    value = state.phoneNumber,
                    label = {
                        Text(
                            text = "Phone Number",
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { onEvent(ContactEvent.SaveContact) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text= "Add to contacts")

                }
            }
        }
    )

}