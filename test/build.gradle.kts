plugins { id("com.android.library") }

apply(from = "../share-config.gradle")

dependencies {
    implementation(Dependency.appCompat)

    implementation(Dependency.retrofit)
}
