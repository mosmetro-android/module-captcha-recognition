# Wi-Fi в метро: Распознавание капчи [![Build Status](https://local.thedrhax.pw/jenkins/buildStatus/icon?job=module-captcha-recognition/master)](https://local.thedrhax.pw/jenkins/job/module-captcha-recognition/job/master/) [![Google Play](.github/resources/google-play.png)](https://play.google.com/store/apps/details?id=pw.thedrhax.captcharecognition) [![ВКонтакте](.github/resources/vk-box.png)](https://vk.com/wifi_v_metro)

Данное приложение является модулем для "Wi-Fi в метро", реализующим автоматическое распознавание капчи.

## Принцип действия

* Основное приложение присылает изображение, закодированное в Base64 через Intent "pw.thedrhax.captcharecognition.RECOGNIZE"
* Модуль производит распознавание текста при помощи библиотеки TensorFlow и специально обученной модели
* Модуль отправляет результат через BroadcastIntent "pw.thedrhax.captcharecognition.RESULT" и завершает работу

## Сборка

Проект импортируется в среду разработки IntelliJ IDEA или совместимые, например Android Studio. Для сборки проекта потребуется Android SDK и Gradle.

## Тестирование в Google Play

Вы можете записаться на тестирование [здесь](https://play.google.com/apps/testing/pw.thedrhax.captcharecognition). Регистрация открыта для всех (просто нужно нажать на кнопку и бета версии начнут приходить вместо обычных). От тестировщиков ничего не требуется, но, если не трудно, сообщайте об ошибках через Issue в этом репозитории.