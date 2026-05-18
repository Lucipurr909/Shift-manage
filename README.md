# Work Shift Tracker

A simple offline work shift manager for Android using Jetpack Compose and Room database.

## Features
- Track work shifts offline
- Local database storage using Room
- Modern Material 3 UI with Jetpack Compose
- Add, view, and manage shifts

## Tech Stack
- **UI:** Jetpack Compose
- **Database:** Room
- **Language:** Kotlin
- **Target:** Android

## Setup Instructions

1. Create a new Empty Compose Activity project in Android Studio (Kotlin)
2. Add dependencies in `app/build.gradle.kts` (see below)
3. Enable KSP in plugins
4. Copy the Kotlin files from `src/main/kotlin/com/example/shifttracker/` directory

## Dependencies

Add these to `app/build.gradle.kts`:

```kotlin
dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    // Date/Time
    implementation("com.google.code.gson:gson:2.11.0")
}
```

## Project Structure

- `ShiftEntity.kt` - Room entity for shift data
- `ShiftDao.kt` - Data Access Object for database operations
- `ShiftDatabase.kt` - Room database setup
- `ShiftViewModel.kt` - ViewModel for business logic
- `MainActivity.kt` - Main UI entry point
- `ShiftScreen.kt` - Compose UI components
