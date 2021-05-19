# base
Project use:
  - MVVP architecture
  - LyfeCircle, live data
  - Room database
  - Coroutine
  - Koin
  - Retrofit

- bài toán giảm thời gian sale 
  + get json từ api, giá trị time sale: time_sale = milisecond
  + Add json vào recycler view 
  + Sử dụng handler post delay 1000 milisecond, lặp lại sau 1000 milisecond 
  + For list sản phẩm, lấy time sale - 1000 milisecond
  + notifidataSetChange lại recycler view 
