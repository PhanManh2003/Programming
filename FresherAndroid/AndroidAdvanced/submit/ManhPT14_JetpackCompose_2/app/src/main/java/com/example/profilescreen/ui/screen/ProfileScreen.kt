package com.example.profilescreen.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.profilescreen.ui.theme.*

//  1. main screen , call call components
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileTopBar()
        Spacer(modifier = Modifier.height(16.dp))
        AvatarSection(
            imageUrl = "https://cdn.britannica.com/87/139487-050-98D3449D/Kaka-2009.jpg"
        )
        Spacer(modifier = Modifier.height(24.dp))
        PersonalInfoCard()
        Spacer(modifier = Modifier.height(16.dp))
        AccountInfoCard()
        Spacer(modifier = Modifier.height(24.dp))
    }
}

//2. Top bar "Profile"
@Composable
fun ProfileTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Profile",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
    }
}

//  3. Avatar +  edit button
@Composable
fun AvatarSection(imageUrl: String) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.size(100.dp)
    ) {
        // image load from internet with coil
        AsyncImage(
            model = imageUrl,
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, White, CircleShape)
        )

        // edit button
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = White,
            shadowElevation = 4.dp,
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = "Edit avatar",
                tint = TextPrimary,
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

// 4. Card "Personal info"
@Composable
fun PersonalInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            // Header
            PersonalInfoHeader()

            Spacer(modifier = Modifier.height(16.dp))

            // info lines
            InfoRow(
                icon = Icons.Outlined.Person,
                label = "Name",
                value = "Phan Tien Manh"
            )
            InfoDivider()
            InfoRow(
                icon = Icons.Outlined.Email,
                label = "E-mail",
                value = "manhamsterdam200303@gmail.com"
            )
            InfoDivider()
            InfoRow(
                icon = Icons.Outlined.Phone,
                label = "Phone number",
                value = "09658399391"
            )
            InfoDivider()
            InfoRow(
                icon = Icons.Outlined.Home,
                label = "Home address",
                value = "19 My Dinh, phuong Cau Giay, Ha Noi"
            )
        }
    }
}

//   5. Header Personal info card
@Composable
fun PersonalInfoHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Personal info",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        TextButton(onClick = { /* TODO: navigate to edit */ }) {
            Text(
                text = "Edit",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
        }
    }
}

// ── 6. Mỗi dòng thông tin (icon + label + value) ──
@Composable
fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = TextPrimary,
            modifier = Modifier
                .size(22.dp)
                .padding(top = 2.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = TextSecondary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 15.sp,
                color = TextPrimary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

//   7. Divider mỏng giữa các InfoRow
@Composable
fun InfoDivider() {
    HorizontalDivider(
        color = DividerColor,
        thickness = 0.8.dp,
        modifier = Modifier.padding(vertical = 2.dp)
    )
}

//   8. Card "Account info"
@Composable
fun AccountInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Account info",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            //
            Text(
                text = "Thêm thông tin tài khoản tại đây...",
                fontSize = 13.sp,
                color = TextSecondary
            )
        }
    }
}