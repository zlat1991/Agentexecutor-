# Agent Executor — MVP 0.1

Это заготовка Android-исполнителя для автономного AI-агента.

## Что уже есть
- Android Accessibility Service с явным разрешением пользователя.
- Выполнение tap/swipe/back/home.
- Чтение видимого текста из Accessibility-дерева.
- Кнопка для включения сервиса.
- Тест открытия браузера.

Android официально позволяет AccessibilityService выполнять жесты через `dispatchGesture()` и глобальные действия после предоставления пользователем соответствующего разрешения.

## Что ещё нужно для автономного цикла
Нужен внешний Agent Loop:
`DeepSeek API -> команда -> Executor -> результат -> DeepSeek API`.

Ключ API в APK не вшивается. Следующий слой должен быть серверным/локальным и передавать только авторизованные команды.

## Сборка на Windows
Требуется Android Studio/Android SDK. В корне проекта выполните:

`gradlew assembleDebug`

либо откройте папку в Android Studio и соберите `app` -> `assembleDebug`.

Готовый debug APK будет в:
`app/build/outputs/apk/debug/app-debug.apk`
