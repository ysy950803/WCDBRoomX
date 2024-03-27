# WCDBRoomX

## Feature

- Adapt [WCDB](https://github.com/Tencent/wcdb/tree/room) to work with the latest version of Room
- Include support for the @Upsert annotation
- Ensure compatibility with the latest version of [SQLCipher](https://github.com/sqlcipher/sqlcipher-android)

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

Add it in your app `build.gradle` :

```groovy
dependencies {
    implementation 'com.github.ysy950803:WCDBRoomX:1.0.0'
}
```

For `*.kts` :

```kotlin
dependencies {
    implementation("com.github.ysy950803:WCDBRoomX:1.0.0")
}
```

### Sample

See [app/src/main/java/com/ysy/wcdbroomx/AppDatabase.kt](https://github.com/ysy950803/WCDBRoomX/blob/main/app/src/main/java/com/ysy/wcdbroomx/AppDatabase.kt)

```kotlin
Room.databaseBuilder(...)
    .openHelperFactory(WCDBRoomX.createOpenHelperFactory("db_password"))
    .build()
```
