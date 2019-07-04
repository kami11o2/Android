 ## Java cơ bản
### 1. Quy tắc đặt tên biến
* Bắt đầu bang một chữ cái hoặc ký tự `_`.
* Chỉ bao gồm các ký tự số, chữ và `_`.
* Không chứa ký tự khoảng trắng.
* Phân biệt chữ hoa và chữ thường.
* Không trùng với từ khóa trong Java.

#### 1.1. Hằng số
* Hằng số là giá trị bất biết.
* Có cú pháp tương tự với biến nhưng them `final` ở đầu.
* Hằng số được thể hiện ở dạng **chữ in hoa +underscore**.
>VD: final int YOUR_BIRTHDAY = 1999

### 2. Hàm toán học cơ bản
* max, min, sqrt, pow.
* Hàm làm tròn: xuống **(ceil)**, lên **(floor)**, gần nhất **(round)**.
* Math.random( ): random 1 số dạng double từ 0 tới 1.
* Công thức random 1 số trong khoảng từ min tới max: `(Math.random( ) * ((max-min)+1) + min`

### 3. Input trong Java
* Khai báo 1 biến Scanner.
>Scanner sc = new Scanner(system.in);  

* Khai báo một biến với kiểu dữ lieu cần nhập và gán với biến Scanner
> String s = sc.nextLine( );

### 4. DecimalFormat
* Format kiểu dữ liệu thành dạng người dung định nghĩa.
>VD:  
>DecimalFormat formatter = new DecimalFormat("#,###");
>System.out.print(formatter.format(15000000));  
>Output: 15,000,000

### 5. Kế thừa trong Java
* Được biểu diễn qua từ khóa `extends`.
>VD:
>class Student extends Person {};  
>Trong đó Student là class con, Person là class cha.
