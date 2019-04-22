private object Versions {
    const val gradleVersion = "3.4.0"
    const val kotlinVersion = "1.3.21"
    const val androidxVersion = "1.1.0-alpha04"
    const val constraintLayoutVersion = "1.1.3"
    const val retrofitVersion = "2.5.0"
    const val navigationVersion = "2.1.0-alpha02"
    const val glideVersion = "4.9.0"
}

object ClassPath {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Dependency {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.androidxVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
}
