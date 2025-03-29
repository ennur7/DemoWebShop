🚀 Selenium_Project_2_

Java Selenium Projesi: Demo Web Shop 

📌 Genel Bakış:

Bu Java Selenium projesi, bir web uygulamasında hesap yönetimiyle ilgili çeşitli senaryoların otomasyonuna odaklanmaktadır. Testlerimizi otomatikleştirmek için “demowebshop.tricentis.com” sitesini kullandık. Tarayıcı otomasyonu için Selenium WebDriver ve betikleme için Java kullanılmıştır.

Kapsanan Senaryolar:

✅ Başarılı Hesap Oluşturma Senaryosu:

•	Web uygulamasında yeni bir hesap oluşturma sürecini otomatikleştirir.

•	Kullanıcı adı, e-posta, şifre gibi geçerli bilgileri girer.

•	Başarılı bir şekilde hesap oluşturulduğunu, bir onay mesajının görüntülenmesi veya kullanıcının kontrol paneline yönlendirilmesiyle doğrular.


❌ Eksik Bilgiyle Hesap Oluşturma Senaryosu:

•	Zorunlu alanlar (e-posta, şifre vb.) boş bırakıldığında uygulamanın davranışını test eder.

•	Kullanıcıdan eksik bilgileri tamamlamasını isteyen hata mesajlarının gösterildiğini doğrular.


? Çıkış Yapma (Logout)- Başarılı Durum:

•	Kullanıcının hesabından çıkış yapma sürecini otomatikleştirir.

•	Kullanıcının giriş sayfasına veya uygun bir başka sayfaya yönlendirildiğini doğrular.


✅ Başarılı Giriş (Login):

•	Geçerli kimlik bilgileriyle giriş yapma fonksiyonunu test eder.

•	Doğru e-posta ve şifre kombinasyonlarını girerek girişin başarılı olup olmadığını kontrol eder.

•	Kullanıcının kontrol paneli veya ana sayfa gibi yalnızca oturum açmış kullanıcılara özel öğeleri görebildiğini doğrular.


❌ Geçersiz Giriş Denemesi (Yanlış E-posta ve/veya Şifre ile):

•	Yanlış kimlik bilgileriyle giriş yapılmaya çalışıldığında uygulamanın nasıl tepki verdiğini test eder.

•	Yanlış e-posta ve/veya şifre kombinasyonları girildiğinde uygun hata mesajlarının görüntülendiğini doğrular.


⛔ Boş (Null) E-posta ve/veya Şifre ile Başarısız Giriş Denemesi:

•	Kullanıcı giriş yapmaya çalışırken e-posta veya şifre alanları boş bırakıldığında uygulamanın verdiği tepkiyi test eder.

•	Giriş butonunun devre dışı kaldığını veya uygun hata mesajlarının görüntülendiğini doğrular.


🛒 Sipariş Verme Süreci: 

•	Kullanıcı kredi kartı kullanarak başarılı bir şekilde sipariş verebilmesini kapsamaktadır.

•	Kullanıcı anasayfadan ürün seçip sepete ekleyebilir ve sepetlerindeki ürünleri görüntüleyebilir. Sipariş sürecinde kargo bilgileri girilir, ödeme yöntemi seçilir ve toplam tutar doğrulanır.

•	Kullanıcı, ödeme işlemini tamamladıktan sonra "Siparişiniz Başarıyla İşleme Alındı!" mesajını görerek siparişin başarılı olduğunu doğrular. Bu süreç, başarılı sipariş akışının yanı sıra eksik veya hatalı girişler için hata mesajlarını da kapsar.


📊 Anket Yanıtı Kontrolü:

•	Kullanıcı, anasayfadaki "Topluluk Anketi (Community Pool)" bölümünde sunulan seçeneklerden birini seçerek oy kullanabilir.

•	Giriş yapmamış kullanıcılar "Sadece Kayıtlı Kullanıcılar Oy Kullanabilir" uyarısı alırken, giriş yapan kullanıcılar oylama sonuçlarını görüntüleyebilir.

•	Sonuç sayfasında, ankete verilen toplam oy sayısı ve dağılımı gösterilir. Bu özellik, kullanıcıların görüşlerini paylaşarak platformla daha fazla etkileşim kurmasına olanak tanır.


⛔ Başarısız Kupon ve Hediye Kartı Kullanımı Kontrolü: 

•	Kullanıcının alışveriş yaparken geçerli bir kupon veya hediye kartı olmaması durumunda alacakları uyarı mesajlarını görmelerini sağlar.

•	Kullanıcılar, indirim olmadan ödeme işlemini tamamladıklarında "Siparişiniz Başarıyla İşleme Alındı!" mesajını görerek siparişin başarılı olduğunu doğrulayabilirler.


📂 Sipariş Geçmişi İndirme Kontrolü:

•	Kullanıcının sipariş geçmişini veya önceki işlemlerini kontrol etme sürecini otomatikleştirir.

•	Sipariş listesinin doğru bir şekilde görüntülendiğini ve sipariş tarihi, durumu gibi bilgilerin eksiksiz olduğunu doğrular ve sipariş bilgilerini içeren faturayı indirebilir. 

📥  Kullanılan Araçlar:

•	Java: Test betikleme için

•	Selenium WebDriver: Tarayıcı otomasyonu için

•	TestNG veya JUnit: Test senaryolarını yönetme ve çalıştırma

•	Maven: Proje ve bağımlılık yönetimi

🌍 Test Ortamı

Proje aşağıdaki test ortamında çalışmaktadır: 

🔗 Demo Web Shop Test Ortamı



🤝 KATKIDA BULUNANLAR:

👤 Ennur Göl - https://github.com/ennur7

👤Tuğba Yılmaz - https://github.com/MTY-EEE

👤Melike Emine Özyavuz - https://github.com/melekOz2

👤Burak Bora Durmaz - https://github.com/burakboradurmaz 

👤Ayşenur Can - https://github.com/aysenur-g-c

👤Murat Öksüz - https://github.com/muratoksuz

👤Serkan Sewöster - https://github.com/SerkanSeweoster

👤İbrahim Can - https://github.com/ibcan9

👤Fazlı Eyüpoğlu - https://github.com/FazliEYP

👤Hakan Mert - https://github.com/ROCK4EVA


📄Sonuç:

Bu Java Selenium projesi, hesap yönetimiyle ilgili çeşitli senaryolar için kapsamlı test kapsamı sağlar.
Hesap oluşturma, giriş, çıkış, doğrulama ve silme gibi işlemlerde karşılaşılabilecek hataların tespit edilmesine yardımcı olarak, web uygulamasının güvenliğini ve kullanıcı deneyimini geliştirir. 

