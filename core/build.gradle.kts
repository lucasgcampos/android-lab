plugins { id("com.android.library") }

apply(from = "../share-config.gradle")

dependencies {
    implementation(Dependency.appCompat)
    implementation(Dependency.recyclerView)
    implementation(Dependency.constraintLayout)

    implementation(Dependency.retrofit)
    implementation(Dependency.converterGson)

    implementation(Dependency.glide)

    testImplementation(project(path = ":test"))
}
