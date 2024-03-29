package com.example.contacts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit
){
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(ContactEvent.ShowDialog)}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Contact"
                )
            }
        },
        topBar = {
            Text(
                text = "Contacts",
                style = MaterialTheme.typography.displayMedium
            )
        }
    ){ padding->
        if (state.isAddingContact){
            AddNew(state = state, onEvent=onEvent)
        }
        LazyColumn (
            contentPadding = padding
        ) {
            items(state.contacts){item ->
                ContactItem(contact = item, onEvent = onEvent)
            }
        }

    }
}

@Composable
fun ContactItem(
    modifier: Modifier = Modifier,
    contact: Contact,
    onEvent: (ContactEvent) -> Unit
){
    Row(
        modifier = modifier
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
            modifier = Modifier
                .size(33.dp)
                .align(Alignment.CenterVertically)
                .clickable { onEvent(ContactEvent.DeleteContact(contact)) }
        )
    }

}
