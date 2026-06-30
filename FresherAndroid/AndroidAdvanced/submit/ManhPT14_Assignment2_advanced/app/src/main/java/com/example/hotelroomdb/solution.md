# overview of package / file

 model
├── RoomType.kt
├── Room.kt
├── Facility.kt
├── RoomTypeFacility.kt
├── RoomTypePhoto.kt
├── Client.kt
├── Occupation.kt
  model.relation
 ├── RoomWithType.kt
 └── OccupationDetail.kt

  model.result
        ├── ClientExpense.kt
        └── YearlyRevenue.kt

 dao
├── RoomTypeDao.kt
├── RoomDao.kt
├── FacilityDao.kt
├── ClientDao.kt
└── OccupationDao.kt

 database
├── AppDatabase.kt
└── PrepopulateCallback.kt --  insert dữ liệu mẫu khi tạo DB lần đầu

 repository
├── RoomRepository.kt
├── ClientRepository.kt
├── OccupationRepository.kt
└── FacilityRepository.kt

 viewmodel          ← MỚI
├── RoomViewModel.kt
├── ClientViewModel.kt
├── OccupationViewModel.kt
└── FacilityViewModel.kt

 adapter
├── RoomAdapter.kt
├── ClientAdapter.kt
├── OccupationAdapter.kt
├── ExpenseAdapter.kt
└── RevenueAdapter.kt

 fragment
├── RoomListFragment.kt
├── ClientListFragment.kt
├── OccupationListFragment.kt
├── OccupationFormFragment.kt
├── ExpenseReportFragment.kt
└── RevenueReportFragment.kt

 activity
└── MainActivity.kt


# 2.XML
 
# 2.1 Layout Activity

activity_main.xml — chứa NavHostFragment + BottomNavigationView

# 2.2 Layout Fragment

fragment_room_list.xml
fragment_client_list.xml
fragment_occupation_list.xml
fragment_occupation_form.xml
fragment_expense_report.xml
fragment_revenue_report.xml

# 2.3 Layout Item RecyclerView

item_room.xml
item_client.xml
item_occupation.xml
item_expense.xml
item_revenue.xml

# 2.4 Navigation

res/navigation/nav_graph.xml — khai báo tất cả fragment + đường đi giữa chúng

# 2.5 Menu

res/menu/bottom_nav_menu.xml — 3 tab chính: Rooms, Clients, Occupations


# 3. Điều hướng giữa các Fragment

Luồng 1 — ViewPager2 cho 3 tab chính
[Rooms] [Clients] [Occupations]
--------------------------------
     Nội dung Fragment
--------------------------------

RoomListFragment
ClientListFragment
OccupationListFragment

3 fragment này ngang hàng nhau, người dùng vuốt qua lại → đúng use case ViewPager2.

Luồng  2 — Navigation Component cho luồng điều hướng
OccupationListFragment
↓
OccupationFormFragment (thêm mới)

OccupationListFragment
↓
ExpenseReportFragment

OccupationListFragment
↓
RevenueReportFragment
Các fragment này có quan hệ cha → con, không ngang hàng → đúng use case Navigation Component.

Tổng thể app
MainActivity
│
├── ViewPager2 (Cách 1)
│       ├── RoomListFragment
│       ├── ClientListFragment
│       └── OccupationListFragment
│               │
│               └── Navigation Component (Cách 2)
│                       ├── OccupationFormFragment
│                       ├── ExpenseReportFragment
│                       └── RevenueReportFragment
