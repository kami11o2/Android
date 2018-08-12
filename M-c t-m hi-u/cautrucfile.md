## Cấu trúc thư mục
### Animation
- Bao gồm các file `XML` để dùng cho hiệu ứng.
### Color State List
- Bao gồm các file `XML` để tự định màu sắc.
### Drawable
- Chứa các file hình ảnh hoặc chứa các file `XML` hình ảnh.
### Layout
- Chứa file `XML` giao diện.
### Menu
- Chứa file `XML` khai báo menu cho ứng dụng.
### Style
- Tùy chỉnh giao diện `action3`.
### Value
- Nơi khai báo các biến.  
>Ex: string, int, char, float, kích thước,...  
## File Dimens
- Giúp các file truy xuất vào lấy ra cái kích thước mong muốn.
## Gradle Scripts
- Có chức năng thay thế các `library`.
- Thay vì phải tìm các `library` để tải về thì **Gradle Scripts** tích hợp sẵn các thư viên trong Android Studio, ta chỉ cần chọn nó rồi add `library` mà mình cần vào, khi có một `library` mới thì nó sẽ tự cập nhật cho mình.
>Main Module: chính là project.  
Resource Grouping: chứa các file hình ảnh, giao diện, kiểu chuỗi, kích thước,...
Main Module Build Script: chứa thư viện.
