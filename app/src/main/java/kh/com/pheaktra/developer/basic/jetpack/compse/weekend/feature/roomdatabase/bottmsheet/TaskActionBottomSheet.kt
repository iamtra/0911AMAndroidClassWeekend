package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase.bottmsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskActionBottomSheet(
    onDelete: () -> Unit = {},
    onEdit: () -> Unit = {}
) {
    ModalBottomSheet(
        onDismissRequest = {

        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        onDelete()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Delete",
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp)
                    .clickable {
                        onEdit()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Edit",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskActionBottomSheetPreview() {
    BaseTheme {
        Scaffold { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
            }
            TaskActionBottomSheet()
        }
    }
}