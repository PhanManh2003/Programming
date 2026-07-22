# res/
│
├── drawable/
│   ├── logo.svg                        ← (đã có) logo chữ F xanh
│   ├── logo_title.svg                  ← (đã có) logo + chữ "facebook"
│   │
│   ├── ic_meta_logo.xml                ← vector: biểu tượng ∞ Meta
│   ├── ic_messenger.xml                ← vector: icon Messenger (circle xanh)
│   ├── ic_search_white.xml             ← vector: kính lúp trắng (header Login)
│   ├── ic_like_white.xml               ← vector: thumbs up trắng (header Login)
│   ├── ic_news_white.xml               ← vector: news/article trắng (header Login)
│   ├── ic_eye_off.xml                  ← vector: icon ẩn password
│   ├── ic_more_vert.xml                ← vector: 3 chấm dọc
│   ├── ic_add_circle.xml               ← vector: dấu + (Log into another account)
│   ├── ic_search_gray.xml              ← vector: kính lúp xám (Find Your Account)
│   ├── ic_back_arrow.xml               ← vector: mũi tên back
│   ├── ic_email.xml                    ← vector: phong bì email (màn OTP)
│   ├── ic_sms.xml                      ← vector: bubble SMS (màn OTP)
│   │
│   ├── bg_login_wave.xml               ← layer-list: background sóng xanh (Login header)
│   ├── bg_btn_blue_rounded.xml         ← shape: nút xanh bo tròn (Log In, Continue)
│   ├── bg_btn_outline_rounded.xml      ← shape: nút viền bo tròn (Create account)
│   ├── bg_otp_box.xml                  ← shape: ô nhập OTP (border xanh)
│   └── shape_divider.xml               ← shape: đường kẻ "OR"
│
├── layout/
│   ├── activity_main.xml               ← chứa <FragmentContainerView> NavHost
│   ├── fragment_splash.xml             ← Splash: logo_title + "From Meta"
│   ├── fragment_input_info.xml         ← Profil Login: avatar + tên + buttons
│   ├── fragment_login.xml              ← Login: email + password + buttons (header xanh)
│   ├── fragment_forgot_password.xml    ← Nhập email tìm tài khoản
│   ├── fragment_otp_verification.xml   ← Nhập 6 chữ số OTP
│   └── fragment_reset_password.xml     ← Tạo mật khẩu mới
│
├── navigation/
│   └── nav_graph.xml                   ← (TẠO MỚI FOLDER) Navigation Graph
│
└── values/
├── strings.xml                     ← cập nhật thêm strings
├── colors.xml                      ← cập nhật màu Facebook
├── themes.xml                      ← giữ NoActionBar
└── dimens.xml                      ← (TẠO MỚI) margin, padding, textSize


# Navigation graph
<!-- startDestination = splashFragment -->

splashFragment
└─ action_splash_to_inputInfo ──────────────────────► inputInfoFragment
│
action_inputInfo_to_login   │  argument: email (String)
▼
loginFragment
│
action_login_to_forgotPassword │  argument: email (String)
▼
forgotPasswordFragment
│
action_forgot_to_otp       │  argument: email (String)
▼
otpVerificationFragment
│
action_otp_to_reset        │  argument: email (String)
▼
resetPasswordFragment
│
popBackStack(loginFragment, false)   │
▼
loginFragment  ← quay về
