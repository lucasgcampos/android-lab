plugins { id("com.android.library") }

apply(from = "../share-config.gradle")

android {
    defaultConfig {
        buildConfigField("String", "API_KEY", getPropertyFromLocalProperties("tmdb.key"))
    }
}

dependencies {
    implementation(project(path = ":core"))

    implementation(Dependency.appCompat)
    implementation(Dependency.recyclerView)
    implementation(Dependency.constraintLayout)

    implementation(Dependency.retrofit)
    implementation(Dependency.converterGson)

    testImplementation(project(path = ":test"))
}

fun getPropertyFromLocalProperties(key: String): String {
    return project.rootProject.file("local.properties").useLines {
        it.find { it.contains(key) }?.split("=", limit = 2)?.get(1)
            ?: throw Throwable("The key '$key' wasn't found in local.properties")
    }
}