# WCDBRoomX

## Feature

- Adapt [WCDB](https://github.com/Tencent/wcdb/tree/room) to work with the latest version of Room
- Include support for the @Upsert annotation
- Ensure compatibility with the latest version of [SQLCipher](https://github.com/sqlcipher/sqlcipher-android)
- Migrate dependencies to AndroidX

## Usage

**Step 1.** Add the JitPack repository to your build file

Add it in your root `build.gradle` or `settings.gradle` at the end of repositories:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

For `*.kts` :

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
```

**Step 2.** Add the dependency

These dependencies are no longer needed:

```
//    implementation("androidx.sqlite:sqlite-ktx:2.4.0")
//    implementation("net.zetetic:sqlcipher-android:4.5.6@aar")
//    implementation("com.tencent.wcdb:wcdb-android:1.1-19")
```

Just add WCDBRoomX in your app `build.gradle` :

```groovy
dependencies {
    implementation 'com.github.ysy950803:WCDBRoomX:1.0.2'
}
```

For `*.kts` :

```kotlin
dependencies {
    implementation("com.github.ysy950803:WCDBRoomX:1.0.2")
}
```

### Sample

See [app/src/main/java/com/ysy/wcdbroomx/AppDatabase.kt](https://github.com/ysy950803/WCDBRoomX/blob/main/app/src/main/java/com/ysy/wcdbroomx/AppDatabase.kt)

WCDBRoomX does not include the Room library. You should add the dependency of Room by yourself:

```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

val roomVersion = "2.6.1"
ksp("androidx.room:room-compiler:$roomVersion")
implementation("androidx.room:room-ktx:$roomVersion")
```

So easy to use WCDB with Room:

```kotlin
Room.databaseBuilder(...)
    .openHelperFactory(WCDBRoomX.createOpenHelperFactory("db_password"))
    .build()
```
