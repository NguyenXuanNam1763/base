# base
Project use:
  - MVVM architecture
  - LyfeCircle, live data
  - Room database
  - Coroutine
  - Koin
  - Retrofit

- bài toán giảm thời gian sale 
  Hiển thị countdown flash sale cho danh sách các sản phẩm cửa 1 cửa hàng.
Cụ thể: thiết kế 1 màn hình hiển thị danh sách 1 list các sản phẩm của 1 cửa hàng. UI e tự thiết kế + mấu chốt là nó có 1 vùng hiển thị phần countdown time.
Dữ liệu trả về có 1 trường: closeTime: time countdown giữa closeTime với thời gian hiện tại. Với thằng item nào khi count =0 thì tự xoá ra khỏi danh sách.
Dữ liệu tạm thời tạo 1 danh sách chuỗi Json rồi dùng Gson parse string to object nhé.
