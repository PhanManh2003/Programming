#  Cấu trúc package (MVVM)
com.example.orderapp
│
├── model/
│   └── FoodItem.kt              // data class: id, name, description, price
│
├── data/
│   └── FoodRepository.kt        // cung cấp danh sách món ăn mẫu (hoặc cho thêm món)
│
├── viewmodel/
│   ├── CartViewModel.kt         // quản lý giỏ hàng (shared giữa Main & Cart)
│   └── FoodListViewModel.kt     // quản lý danh sách món ăn (DiffUtil ở đây)
│
├── adapter/
│   ├── FoodAdapter.kt           // RecyclerView.Adapter + DiffUtil.ItemCallback
│   └── CartAdapter.kt           // RecyclerView.Adapter cho giỏ hàng
│
├── ui/
│   ├── MainActivity.kt
│   └── CartActivity.kt
│
└── res/layout/
    ├── activity_main.xml
    ├── activity_cart.xml
    ├── item_food.xml
    └── item_cart.xml