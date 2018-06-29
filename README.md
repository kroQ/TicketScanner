# TicketScanner server side

Jest to projekt, który stworzyłem na pracę magisterską.

TicketScanner to strona serwerowa systemu, który pozwala skanować kody QR z aplikacji TicketScannerAndroid. 

Lista technologii, frameworków i narzędzi, których użyłem do tego projektu:

IntelliJ IDEA
Android Studio
Java
Spring
Hibernate
PostgeSQL
Postman

Komunikacja między aplikacją a serwerem odbywa się za pomocą przesyłania JSONów na konkretne usługi sieciowe (web services - REST). Podczas pisania kodu starałem się zachować zasady SOLID

Sercem aplikacji - biblioteką do skanowania kodów QR - jest biblioteka ZXing a dokładniej projekt, który na niej bazuje:  ZXing  Android  Embedded. (https://github.com/journeyapps/zxing-android-embedded)

Kody QR powinny przypominać format JSON w postaci:

"name":"Mateusz", 


"surname":"Krok", 

"email":"krok@gmail.com",

"city":"Kraków", 

"street":"Rynek 1",

"frat_nr":"33/4",

"sex":"M",

"birth_date":"31-05-1993",

"phone":753159456,

"seat_nr":"F 5445",

"code":"3215DFG-ASDF/E"

Schemat ten można zmienić, edytując klasy Ticket (TicketData, TicketMapper, TicketService itp.) oraz tabelę TICKETS definiowaną w pliku tickets.ddl


