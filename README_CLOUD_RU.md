# Сборка APK без ПК

Проект подготовлен для облачной сборки через GitHub Actions. GitHub-hosted runner собирает Android-проект, а результат APK сохраняется как workflow artifact.

## Как получить APK с телефона
1. Создай пустой репозиторий на GitHub.
2. Загрузите содержимое этой папки в репозиторий так, чтобы `.github/workflows/build-apk.yml` находился именно по этому пути.
3. Открой вкладку **Actions**.
4. Выбери **Build Android APK** и запусти **Run workflow**.
5. После окончания открой запуск workflow и скачай artifact **AgentExecutor-debug-apk**.

Для последующих изменений достаточно загрузить новую версию проекта и снова запустить workflow.
