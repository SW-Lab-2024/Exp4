# Exp4: Profiling and BDD Implementation in Java

<div dir="rtl">

## پرسش‌ها

۲- در انتهای مستند هنگام اجرای Scenario Outline برخی تست‌ها به مشکل undefined برمی‌خورند.

### این موارد تست کدامند؟
ردیف دوم example یعنی ورودی -۱ و ۶

### علت بروز مشکل چیست؟
در قسمت `given` یعنی تابع `twoInputValuesAnd`، رجکس تعریف شده برای گرفتن دو عدد به درستی تعریف نشده است و در تست به مشکل خورده، ورودی -۱ داده شده که منفی است.

### مشکل را با تغییر کد رفع کنید
با اضافه کردن `-` به رجکس گرفتن عددها، دیگر از اعداد منفی هم پشتیبانی می‌شود و قابل قبول هستند. (؟ در رجکس به معنای ۰ یا یک می‌باشد.)

## تمرین‌های بخش Profiling:

### عملیات Profiling بر روی JavaCup:
ابتدا با انجام تست پروفایلینگ می‌بینیم که منابع به چه شکلی تخصیص داده می‌شوند. در اینجا رشد CPU Time را با دادن هر ورودی به آن مشاهده می‌کنیم و می‌بینیم که رشد صعودی دارد.
![image](https://github.com/user-attachments/assets/05737529-53da-4a52-8d75-956bbd8d8a65)

همچنین خلاصه‌ای از بخش Runtime در بخش Summary مشاهده می‌کنیم.
![image](https://github.com/user-attachments/assets/4058a3dc-3f0b-4a5f-8624-da24fcb67d13)

### خلاصه‌ای از بخش‌های تخصیص حافظه:
![image](https://github.com/user-attachments/assets/0e0cc48b-2741-4b8e-a5c9-672ed07e627f)

همانطور که می‌بینید تابع `temp` تابعی است که بیشترین منبع را اشغال می‌کند و به عنوان Hotspot Method نمایش داده شده است، پس باید این تابع را بهینه کنیم:
![image](https://github.com/user-attachments/assets/7f27b2c8-bfb4-4b61-bfdb-6c8ab60cf1bd)

### تغییرات ایجاد شده در تابع temp برای بهینه‌سازی:
![image](https://github.com/user-attachments/assets/4587fced-7bf4-4f3a-a5e4-6e1fbe4f25bf)

مشکل کد قبلی در متد `temp` این بود که از دو حلقه تو در تو برای اضافه کردن مقادیر به یک `ArrayList` استفاده می‌کرد. این باعث می‌شد که تعداد زیادی عنصر به لیست اضافه شود که به شدت حافظه را اشغال کرده و عملکرد برنامه را کاهش می‌داد. در این کد، دو حلقه تو در تو داریم که برای هر ترکیب از `i` و `j` یک مقدار به لیست اضافه می‌کنند. این کار باعث می‌شود لیست خیلی بزرگ شود و زمان زیادی صرف اضافه کردن عناصر به آن شود.

### روش بهبود کد:
برای بهبود این کد، تغییراتی ایجاد شد تا استفاده از منابع بهینه‌تر شود. حالا لیست را یکبار ایجاد می‌کنیم و مقادیر را به آن اضافه می‌کنیم، سپس در حلقه‌های تو در تو به جای اضافه کردن مقادیر جدید به لیست، روی مقادیر موجود عملیات انجام می‌دهیم.

با اعمال ایجاد یکباره لیست (به جای اضافه کردن مقادیر به لیست در هر تکرار حلقه تو در تو، یکبار لیست را با اندازه ثابت ایجاد می‌کنیم و مقادیر را به آن اضافه می‌کنیم) و پردازش اعضای لیست در حلقه‌های تو در تو به جای اضافه کردن مقادیر جدید به لیست، مقادیر موجود را پردازش می‌کنیم. این باعث کاهش مصرف حافظه و بهبود عملکرد می‌شود.

## ایجاد قطعه کد جدید و بهبود آن
ما در اینجا یک پروژه نقشه مترو را پیاده‌سازی کرده‌ایم. در آن نخست ایستگاه‌های مختلف و خط‌های موجود در هر مترو و اتصال آنها را ایجاد می‌کنیم. سپس با گرفتن دو ایستگاه به عنوان ورودی، مسیر بین آنها توسط برنامه به ما نمایش داده می‌شود. ابتدا آن را با DFS حل می‌کنیم. طی روند پروژه به نامناسب بودن این الگوریتم با مشاهده روند اختصاص منابع پی می‌بریم. سپس آن را بهینه می‌کنیم و از الگوریتم BFS استفاده می‌نماییم. هر بخش پروژه وقتی مسیر بین دو ایستگاه طی می‌شود آن را در خروجی نمایش داده و همچنین مدت انجام آن ۱ ثانیه طول می‌کشد.

## انجام تست پروفایلینگ در الگوریتم DFS:
![image](https://github.com/user-attachments/assets/132f3b4c-064c-4154-a2df-a09119d6937d)

همانطور که می‌بینید بخش عظیمی درگیر ران کردن بخش مربوط به DFS کد بوده است:
![image](https://github.com/user-attachments/assets/16ddd742-8d90-4c1d-8341-f71db517f364)

### بخش مموری:
![image](https://github.com/user-attachments/assets/b60293ae-f02c-43a3-8cc3-83889ea001df)

### خلاصه ران تایم:
![image](https://github.com/user-attachments/assets/cb4c7680-6f62-4b4d-9f86-1acf8529f0bc)

همانطور که در بخش Hotspots می‌بینیم، به این موضوع اشاره شده که متود `findPathNaive` بخش زیادی از زمان را به خود اختصاص می‌دهد پس باید آن را بهینه کنیم:
![image](https://github.com/user-attachments/assets/794fa14f-a582-41f6-b8d9-1602e88a4732)

## انجام تست پروفایلینگ در الگوریتم BFS:
### زمان‌بندی CPU با الگوریتم BFS:
![image](https://github.com/user-attachments/assets/792478a2-11c8-4071-89ad-cfd59e7aef82)
![image](https://github.com/user-attachments/assets/b789ebb9-1333-4ed9-af90-5db4eac4b9c0)
![image](https://github.com/user-attachments/assets/493bf9f2-97e8-4d83-b4e0-976402e63d72)

### خلاصه‌ای از ران تایم:
![image](https://github.com/user-attachments/assets/ffe491b0-58de-4200-b37f-ca61ff992b79)

### وضعیت حافظه:
![image](https://github.com/user-attachments/assets/2f9d60a4-e51d-4bfd-b775-20849d4940fa)

همانطور که دیدیم کل روند اختصاص منابع (چه حافظه و چه CPU) بهبود یافت.

</div>
