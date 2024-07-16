package com.check.purchaseProductList.composables

import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import com.check.designsystem.theme.CustomTheme

@Composable
fun ErrorPopup(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Probleme")
        },
        text = {
            Text("Die Daten konnten nicht geladen werden.")
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Neuladen")
            }
        },
        icon = {
            Icon(Icons.Default.Error, contentDescription = null, tint = CustomTheme.colors.LightRed)
        }
    )
}
