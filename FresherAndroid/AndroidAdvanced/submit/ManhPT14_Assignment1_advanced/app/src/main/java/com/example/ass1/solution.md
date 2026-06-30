# requirement
Write a Contact app which:
• Display download button when start app
• Click download → load all contact from database and display on screen.
• For requirement loading contact:
o Use SQLlite for database.
o Display download percent
• Freestyle for layout

# solution
com.example.contactapp/
│
├── model/
│   ├── Contact.kt                      # Room @Entity (domain model)
│   ├── ContactDao.kt                   # @Dao interface
│   ├── ContactDatabase.kt              # @Database singleton (Room)
│   └── ContactRepository.kt           # Repository – cầu nối data ↔ ViewModel
│
├── view/
│   ├── MainActivity.kt                # Activity (View)
│   ├── ContactAdapter.kt              # RecyclerView Adapter
│   └── res/
│       ├── layout/activity_main.xml   # Layout chính (DataBinding)
│       └── layout/item_contact.xml    # Layout từng item
│
├── viewmodel/
│   └── MainViewModel.kt              # ViewModel – xử lý logic, expose LiveData
│
└── utils/
└── Constants.kt                   # Hằng số (optional)


# LUỒNG NGHIỆP VỤ 
User nhấn Download
│
▼
MainActivity.onClickDownload()
│
▼
MainViewModel.downloadContacts()        ← viewModelScope (Coroutine)
│
▼
ContactRepository.loadContacts()        ← suspend fun
│  (query từng batch 10 records, emit progress: 10% → 20% → ... → 100%)
▼
ContactDao.getAllContacts()             ← Room / SQLite (auto background thread)
│
▼
Sau mỗi batch → downloadProgress.postValue(%)
contacts.postValue(list)
│
▼
MainActivity observe → ProgressBar cập nhật % + RecyclerView cập nhật list