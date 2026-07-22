# folder structure
com.example.recipeapp
│
├── MainActivity.kt
│
├── model/
│   └── Recipe.kt                    // data class Recipe
│
├── data/
│   └── RecipeProvider.kt            // object cung cấp data + hàm search
│
├── viewmodel/
│   └── RecipeViewModel.kt           // xử lý search, quản lý state bằng Flow
│
├── ui/
│   ├── theme/
│   │   ├── Color.kt                 // màu light + dark theo figma
│   │   ├── Theme.kt                 // MaterialTheme tự động đổi light/dark
│   │   └── Type.kt                  // typography
│   │
│   └── screen/
│       ├── RecipeScreen.kt          // màn hình chính (gọi các composable nhỏ)
│       ├── SearchBar.kt             // composable thanh tìm kiếm
│       ├── RecipeList.kt            // composable LazyColumn danh sách
│       ├── RecipeItem.kt            // composable 1 item recipe
│       ├── ImagePager.kt            // composable HorizontalPager + indicator
│       └── PagerIndicator.kt        // composable các chấm tròn indicator
│
└── res/
└── drawable/
├── monan1.jpg               // ảnh sẵn có
├── monan2.jpg
└── monan3.jpg