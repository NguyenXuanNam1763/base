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

- dữ liệu đầu vào: dạng milisecond: được chuyển từ định dạng ngày/tháng/năm - giờ/ phút/ giây.

- dữ liệu đầu ra: thời gian hiện tại - thời gian đầu vào: chuyển hiệu này thành dạng ngày còn lại: ví dụ: 32 ngày 04:03:01 đếm ngược về 0

- Đã theo dõi hiệu năng trên 100 phần tử cùng lúc. Dung lượng ram chiếm trong hệ thống: giao động từ 30mb đến 100mb.

- Phân tích bài toán: Vì thời gian ở mỗi phần tử là như nhau. đều sẽ có thay đổi đó là giảm đi theo thời gian thực( 1s sẽ giảm 1 lần). Nếu bình thường chúng ta sẽ nghĩ đến ngay sử dụng handler hoặc countdowntime cho mỗi phần tử vì thời gian kết thúc là khác nhau. Nhưng bản chất nó vẫn chỉ là giảm thời gian trong 1s. Chúng ta sẽ chỉ sử dụng 1 handler để controller toàn bộ item. 
     + ưu điểm của handler: tự động kết thúc phiên sau khi nó được gọi và hoàn thành nhiệm vụ. Nó chiếm lượng ram rất nhỏ, dễ  thao tác.
- Sau mỗi 1s chúng ta sẽ gọi lại handler 1 lần và xử lý thời gian giảm đi trong time sale của item. mối giây 1 lần. nên chúng ta sẽ không tác động vào time sale. mà system.curenttime sẽ làm điều đó. 
- Bắt buộc phải dùng RecyclerView: Nó đượuc tối ưu hóa loadmore. Cho phép chỉ hoạt động khi item được show lên màn hình. Các phần tử bị ẩn sẽ không chiếm rất ít dung lượng ram.
- Glide cho phép chúng ta load ảnh. có thể điều chỉnh chất lượng ảnh nếu bạn muốn.
- Sử dụng live data để trách trường hợp crash do ko tìm thấy id trên UI 

- Tích hợp loadmore cho recyclerview. mỗi lần 10 item mới 
